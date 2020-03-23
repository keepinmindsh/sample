package lines.reactive.sample.sample08.handler;


import lines.reactive.sample.sample08.command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CommandHandler {

    private final List<Command> commandList = new ArrayList<>();
    List<Future<?>> futures = new ArrayList<>();

    private final ExecutorService executorService;

    public CommandHandler(int threadCount){
        executorService = Executors.newFixedThreadPool(threadCount);
    }

    public void StartAPICall() {

        commandList.forEach(command -> {
            futures.add(executorService.submit(command::execute, "Success"));
        });

        for(Future<?> future : futures) {
            try {
                future.get();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

    private void useCompletableFurture(){
        List<Runnable> runnableList = new ArrayList<>();
        commandList.forEach(command -> {
            runnableList.add(command::execute);
        });

        CompletableFuture<?>[] futures = runnableList.stream()
                .map(task -> CompletableFuture.runAsync(task, executorService))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

        executorService.shutdown();
    }

    public synchronized void add(Command command) {
        commandList.add(command);
    }
}
