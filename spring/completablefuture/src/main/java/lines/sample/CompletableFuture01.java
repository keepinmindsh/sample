package lines.sample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CompletableFuture01 {
    public static void main(String[] args) throws InterruptedException {
        // Async 작업이 끝나고 해당 스레드에서 계속해서 작업을 수행한다.
        CompletableFuture
                .runAsync(() -> { log.info("runAsync");})
                .thenRun(() -> { log.info("thenRun");})
                .thenRun(() -> { log.info("thenRun");});

        log.info("exit");

        ForkJoinPool.commonPool().shutdown();
        ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);
    }
}
