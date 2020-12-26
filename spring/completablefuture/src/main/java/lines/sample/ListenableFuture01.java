package lines.sample;

import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

@Slf4j
public class ListenableFuture01 {
    public static void main(String[] args) {
        ListeningExecutorService executor =
                MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));

        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "TASK";
            }
        };

        ListenableFuture<String> listenableFuture = executor.submit(task);

        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                log.info("Result : {} ","SUCCESS");
            }
            @Override
            public void onFailure(Throwable thrown) {
                log.error("FAILURE : " + thrown.getMessage());
            }
        });

        listenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    log.info("Result : {} ",listenableFuture.get());
                } catch (Exception e) {
                    log.error("EXCEPTION : " + e.getMessage());
                }
            }
        }, executor);
    }
}
