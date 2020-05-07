package sample.SaltEncription;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


@Slf4j
public class Sample {

    public static void main(String[] args) {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setPassword("**********");
        dataSource.setUsername("**********");
        dataSource.setUrl("jdbc:oracle:thin:@**********:**********");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<User> list = jdbcTemplate.query("SELECT USER_ID, PWD FROM TB_ZZ_USER", ( rs, rownum ) -> {
            User user = new User();

            user.setPWD(rs.getString("PWD"));
            user.setUSER_ID(rs.getString("USER_ID"));

            return user;
        });

        log.info(list.toString());

        list.forEach(item -> {
            log.info(item.getUSER_ID() +  ":" + item.getPWD());

            String bcryptHashString = BCrypt.withDefaults().hashToString(12, (item.getUSER_ID() + "@1234").toCharArray());

            jdbcTemplate.update("UPDATE TB_ZZ_USER SET PWD = ?  WHERE USER_ID = ?" , bcryptHashString ,  item.getUSER_ID());

        });

        List<User> resultList = jdbcTemplate.query("SELECT USER_ID, PWD FROM TB_ZZ_USER", ( rs, rownum ) -> {
            User user = new User();

            user.setPWD(rs.getString("PWD"));
            user.setUSER_ID(rs.getString("USER_ID"));

            return user;
        });

        resultList.forEach(item -> {

                    BCrypt.Result result = BCrypt.verifyer().verify((item.getUSER_ID() + "@1234").toCharArray(), item.getPWD());

                    log.info(item.getUSER_ID() + ":" + item.getPWD());
                    log.info("값이 동일합니다 :  " + result.verified);

                }
        );
    }

    @Getter
    @Setter
    static class User{
        private String USER_ID;
        private String PWD;
    }
}

