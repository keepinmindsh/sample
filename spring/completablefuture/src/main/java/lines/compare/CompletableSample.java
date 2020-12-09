package lines.compare;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CompletableSample {

    static Runnable task = () -> {
        try {
            TimeUnit.SECONDS.sleep(51);
            log.info("Task 실행");
        }catch (Exception exception){
            Thread.currentThread().interrupt();
        }
        log.info("TASK completed");
    };

    public static void completableFuture() throws Exception {
        CompletableFuture
                .runAsync(task)
                .thenCompose(aVoid -> CompletableFuture.completedFuture(task))
                .thenAcceptAsync(aVoid -> log.info("all tasks completed"))
                .exceptionally(throwable -> {
                    log.error("Exception Occurred!");
                    return null;
                });

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception exception){
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        try {
            completableFuture();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}


