package lines.reactive.sample.sample09.command;

import lines.reactive.sample.sample09.builder.CommandBuilder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

//import oracle.jdbc.OracleTypes;

public class SelectDBCommand implements Command {

    private final CommandBuilder commandBuilder;

    public SelectDBCommand(CommandBuilder commandBuilder){
        this.commandBuilder = commandBuilder;
    }

    @Override
    public void execute() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.commandBuilder.getDataSource());

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);

        simpleJdbcCall.withCatalogName("**********")
                .withProcedureName("**********")
                .withNamedBinding()
                .declareParameters(
                        new SqlParameter("V_IN_BSNS_CODE", Types.VARCHAR),
                        new SqlOutParameter("V_OUT_YN", Types.VARCHAR),
                        new SqlOutParameter("V_OUT_MSG", Types.VARCHAR),
                        new SqlOutParameter("V_REF_CURSOR", Types.REF_CURSOR, BeanPropertyRowMapper.newInstance(HashMap.class))
                );

        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("**********", "11");

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(paramMap);

        Map<String, Object> dataMap = simpleJdbcCall.execute(sqlParameterSource);

        System.out.println(dataMap);

    }
}
