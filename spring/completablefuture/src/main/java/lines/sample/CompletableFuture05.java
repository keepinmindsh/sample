package lines.sample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CompletableFuture05 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        // Async 작업이 끝나고 해당 스레드에서 계속해서 작업을 수행한다.
        CompletableFuture
                .supplyAsync(() -> {
                    log.info("supplyAsync");
                    return 1;
                }, es)
                // return이 CompletableFuture인 경우 thenCompose를 사용한다.
                .thenCompose(s -> {
                    log.info("thenApply {}", s);
                    return CompletableFuture.completedFuture(s + 1);
                })
                // 앞의 비동기 작업의 결과를 받아 사용해 새로운 값을 return 한다.
                .thenApply(s -> {
                    log.info("thenApply {}", s);
                    return s + 2;
                })
                // 이 작업은 다른 스레드에서 처리를 하려고 할 때, thenApplyAsync를 사용한다.
                // 스레드의 사용을 더 효율적으로 하고 자원을 더 효율적으로 사용한다.
                // 현재 스레드 풀의 정책에 따라서 새로운 스레드를 할당하거나 대기중인 스레드를 사용한다. (스레드 풀 전략에 따라 다르다.)
                .thenApplyAsync(s -> {
                    log.info("thenApply {}", s);
                    return s + 3;
                }, es)
                .exceptionally(e -> {
                    log.info("exceptionally");
                    return -10;
                })
                // 앞의 비동기 작업의 결과를 받아 사용하며 return이 없다.
                .thenAcceptAsync(s -> log.info("thenAccept {}", s), es);
        log.info("exit");

        // 별도의 pool을 설정하지않으면 자바7 부터는 ForkJoinPool이 자동으로 사용된다.
        ForkJoinPool.commonPool().shutdown();
        ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);
    }
}
