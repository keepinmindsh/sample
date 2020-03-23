package lines.reactive.sample.sample08;

import lines.reactive.sample.sample08.command.Command;
import lines.reactive.sample.sample08.mapper.CustomMapper;
import lines.reactive.sample.sample08.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class SelectDBCommand implements Command {

    private final DataSource dataSource;

    public SelectDBCommand(DataSource dataSource){
        this.dataSource =  dataSource;
    }

    @Override
    public void execute() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<User> list =  jdbcTemplate.query("SELECT USER_ID FROM TB_ZZ_USER", new CustomMapper());

        System.out.println("START" + Thread.currentThread().getName());
        list.stream().forEach(item -> {
            System.out.print(item.getUSER_ID() + ",");
        });
        System.out.println("END" + Thread.currentThread().getName());
    }
}
