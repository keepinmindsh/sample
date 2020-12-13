package lines.sample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CompletableFuture02 {
    public static void main(String[] args) throws InterruptedException {
        // Async 작업이 끝나고 해당 스레드를 계속해서 작업한다.
        CompletableFuture
                .supplyAsync(() -> {
                    log.info("supply Async");
                    return 1;
                })
                // 앞의 비동기 작업의 결과를 받아 사용해 새로운 값을 return 한다.
                .thenApply(s -> {
                    log.info("thenApply {}" , s);
                    return s + 1;
                })
                // 앞의 비동기 작업의 결과를 받아 사용하며 return이 없다.
                .thenAccept(s -> {
                    log.info("thenAccept {}", s);
                });

        log.info("Exit");

        // 별도의 pool을 설정하지않으면 자바7 부터는 ForkJoinPool이 자동으로 사용된다.
        ForkJoinPool.commonPool().shutdown();
        ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);
    }
}
