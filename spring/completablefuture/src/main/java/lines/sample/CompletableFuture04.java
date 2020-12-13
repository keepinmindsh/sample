package lines.sample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CompletableFuture04 {

    public static void main(String[] args) throws InterruptedException {
        // Async 작업이 끝나고 해당 스레드에서 계속해서 작업을 수행한다.
        CompletableFuture
                .supplyAsync(() -> {
                    log.info("supplyAsync");
                    return 1;
                })
                // return이 CompletableFuture인 경우 thenCompose를 사용한다.
                .thenCompose(s -> {
                    log.info("thenApply {}", s);
                    if (1 == 1) throw new RuntimeException();
                    return CompletableFuture.completedFuture(s + 1);
                })
                // 앞의 비동기 작업의 결과를 받아 사용해 새로운 값을 return 한다.
                .thenApply(s -> {
                    log.info("thenApply {}", s);
                    return s + 1;
                })
                .exceptionally(e -> {
                    log.info("exceptionally");
                    return -10;
                })
                // 앞의 비동기 작업의 결과를 받아 사용하며 return이 없다.
                .thenAccept(s -> log.info("thenAccept {}", s));

        log.info("exit");

        // 별도의 pool을 설정하지않으면 자바7 부터는 ForkJoinPool이 자동으로 사용된다.
        ForkJoinPool.commonPool().shutdown();
        ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);
    }
}
