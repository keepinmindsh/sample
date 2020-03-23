package lines.reactive.sample;


import lines.reactive.sample.sample09.builder.CommandBuilder;
import lines.reactive.sample.sample09.command.Command;
import lines.reactive.sample.sample09.command.SelectDBCommand;
import lines.reactive.sample.sample09.command.handler.CommandHandler;
import lines.reactive.sample.sample09.reactive.CustomPublisher;
import lines.reactive.sample.sample09.reactive.CustomSubsriber;
import org.apache.commons.dbcp2.BasicDataSource;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Sample09_reactiveStreams09 {
    public static void main(String[] args) {

        // DataSource & Init
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName("**********");
        basicDataSource.setUrl("**********");
        basicDataSource.setUsername("**********");
        basicDataSource.setPassword("**********");

        CommandBuilder.Builder commandBuilder = new CommandBuilder.Builder();

        commandBuilder.setDataSource(basicDataSource);

        Command command = new SelectDBCommand(commandBuilder.build());

        List<Command> commandList = new ArrayList<>();

        commandList.add(command);

        CommandHandler commandHandler = new CommandHandler(commandList);

        // Publisher
        Publisher<CommandHandler> publisher = new CustomPublisher(commandHandler);

        // Subscriber
        Subscriber<CommandHandler> subscriber = new CustomSubsriber();

        // Publisher Execute
        publisher.subscribe(subscriber);
    }
}
