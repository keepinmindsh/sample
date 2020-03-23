package lines.reactive.sample.sample08.command;

import com.reactive.reactive.sample.sample08.builder.CommandBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SelectDBCommand implements Command {

    private final CommandBuilder commandBuilder;

    public SelectDBCommand(CommandBuilder commandBuilder){
        this.commandBuilder =  commandBuilder;
    }

    @Override
    public void execute() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(commandBuilder.getDataSource());
        List<?> list =  jdbcTemplate.query(commandBuilder.getQuery(), commandBuilder.getRowMapper());
        System.out.println("START" + Thread.currentThread().getName());
        System.out.println("END" + Thread.currentThread().getName());
    }
}
