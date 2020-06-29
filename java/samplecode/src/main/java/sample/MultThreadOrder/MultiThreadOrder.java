package sample.MultThreadOrder;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MultiThreadOrder {

    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

    private static int sharedValue = 10;

    public static void main(String[] args) {

        List<Future> futureList = new ArrayList<>();

        futureList.add(ExecuteThread(18));
        futureList.add(ExecuteThread(14));
        futureList.add(ExecuteThread(21));

        futureList.forEach(item -> {

            try {
                log.info("Value : {} ", item.get());
            } catch (Exception exception){
                log.error(exception.getMessage());
                exception.printStackTrace();
            }
        });

        executorService.shutdown();

    }

    public static Future ExecuteThread(int value){
        return executorService.submit(() -> {
            Thread.sleep(2000);
            sharedValue = value;

            return sharedValue;
        });
    }
}
