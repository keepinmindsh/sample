package lines.reactive.sample.sample09.command.handler;

import com.reactive.reactive.sample.sample09.command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CommandHandler {

    private final ExecutorService executorService;

    private List<Future> futureList = new ArrayList<>();

    private final List<Command> commandList;

    public CommandHandler(List<Command> commandList){
        this.commandList = commandList;

        this.executorService = Executors.newFixedThreadPool(this.commandList.size());
    }

    public void CommandExecute(){
        commandList.forEach(item -> {
               Future future = executorService.submit(item::execute);

               futureList.add(future);
            }
        );

        futureList.forEach(future ->{
            try {
                future.get();
            } catch(Exception e){
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

}
