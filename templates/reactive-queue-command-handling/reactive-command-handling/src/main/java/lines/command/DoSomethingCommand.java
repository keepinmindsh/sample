package lines.command;

import lines.command.inf.Command;
import lines.queue.QueueStorage;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class DoSomethingCommand implements Command<Boolean> {

    private ExecutorService executorService;

    @Override
    public Boolean execute() {

        List queueList = QueueStorage.deQueue();

        AtomicBoolean isPass = new AtomicBoolean(true);

        if(queueList.size() > 0){
            List<Future> futureList = new ArrayList<>();

            int queueSize = queueList.size();

            if(queueSize / 4 < 4 ){
                queueSize = 1;
            }else{
                queueSize = queueSize / 4;
            }

            executorService = Executors.newFixedThreadPool(queueSize);

            queueList.forEach(item -> {
                futureList.add(executorService.submit( () -> {
                    log.info("Request : {}", item);
                }));
            });

            futureList.forEach(item -> {
                try {
                    item.get();
                } catch (Exception exception) {
                    exception.printStackTrace();

                    isPass.set(false);
                }
            });
        }

        if(executorService != null){
            if(!executorService.isShutdown()){
                executorService.shutdown();
            }
        }

        return isPass.get();
    }
}
