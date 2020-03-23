package lines.reactive.sample;


import lines.reactive.sample.sample08.SamplePublisher;
import lines.reactive.sample.sample08.SampleSubscriber;
import lines.reactive.sample.sample08.SelectDBCommand;
import lines.reactive.sample.sample08.builder.CommandBuilder;
import lines.reactive.sample.sample08.command.ProcedureDBCallCommand;
import lines.reactive.sample.sample08.handler.CommandHandler;
import lines.reactive.sample.sample08.model.Data;
import org.apache.commons.dbcp2.BasicDataSource;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import oracle.jdbc.OracleTypes;

public class Sample08_reactiveStreams08 {
    public static void main(String[] args) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@************:*******/*******");
        dataSource.setUsername("*******");
        dataSource.setPassword("*******");

        BasicDataSource dataSource2 = new BasicDataSource();
        dataSource2.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource2.setUrl("jdbc:oracle:thin:@*******:*******/*******");
        dataSource2.setUsername("*******");
        dataSource2.setPassword("*******");

        CommandBuilder.Builder builder = new CommandBuilder.Builder();

        builder.setDataSource(dataSource2);
        builder.setPackageName("*****");
        builder.setStoredProcedureName("******");
        builder.setSqlParameters(new SqlParameter[]{
                new SqlParameter("V_IN_BSNS_CODE", Types.VARCHAR),
                new SqlOutParameter("V_OUT_YN", Types.VARCHAR),
                new SqlOutParameter("V_OUT_MSG", Types.VARCHAR),
                new SqlOutParameter("V_OUT_REF_CURSOR", Types.REF_CURSOR, BeanPropertyRowMapper.newInstance(Data.class))
        });

        Map<String, Object> inParamMap = new HashMap<String, Object>();
        inParamMap.put("V_IN_BSNS_CODE", "11");

        builder.setParameterMap(inParamMap);

        CommandHandler commandHandler1 = new CommandHandler(1);

        //commandHandler1.add(new SelectDBCommand(dataSource));
        commandHandler1.add(new ProcedureDBCallCommand(builder.build()));
        commandHandler1.add(new SelectDBCommand(dataSource2));
        commandHandler1.add(new SelectDBCommand(dataSource2));
        commandHandler1.add(new SelectDBCommand(dataSource2));
        commandHandler1.add(new SelectDBCommand(dataSource2));
        commandHandler1.add(new SelectDBCommand(dataSource2));
        commandHandler1.add(new SelectDBCommand(dataSource2));
        /*
        commandHandler1.add(new SelectDBCommand(dataSource));
        commandHandler1.add(new SelectDBCommand(dataSource));
        commandHandler1.add(new SelectDBCommand(dataSource));*/
/*
        CommandHandler commandHandler2 = new CommandHandler(1);*/
/*
        commandHandler2.add(new SelectDBCommand(dataSource));
        commandHandler2.add(new SelectDBCommand(dataSource));
        commandHandler2.add(new SelectDBCommand(dataSource));
        commandHandler2.add(new SelectDBCommand(dataSource));*/

        List<CommandHandler> commandHandlerList = new ArrayList<>();

        commandHandlerList.add(commandHandler1);/*
        commandHandlerList.add(commandHandler2);*/

        Publisher<CommandHandler> publisher = new SamplePublisher(commandHandlerList);

        Subscriber<CommandHandler> subscriber = new SampleSubscriber(commandHandlerList.size());

        publisher.subscribe(subscriber);
    }
}
