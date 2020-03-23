package lines.reactive.sample.sample08.command;

import com.reactive.reactive.sample.sample08.builder.CommandBuilder;
import com.reactive.reactive.sample.sample08.model.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.util.List;
import java.util.Map;

public class ProcedureDBCallCommand implements Command {

    private CommandBuilder commandBuilder;

    public ProcedureDBCallCommand(CommandBuilder commandBuilder){
        this.commandBuilder = commandBuilder;
    }

    @Override
    public void execute() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(commandBuilder.getDataSource());
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(commandBuilder.getPackageName())
                .withProcedureName(commandBuilder.getStoredProcedureName())
                .withoutProcedureColumnMetaDataAccess()
                .withNamedBinding()
                .declareParameters(commandBuilder.getSqlParameters());

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(commandBuilder.getParameterMap());

        Map<String, Object> result = simpleJdbcCall.execute(sqlParameterSource);

        ((List<Data>)result.get("V_OUT_REF_CURSOR")).forEach(data -> {
            System.out.println(data.toString());
        });
    }
}
