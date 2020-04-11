package lines.reactive.sample.sample32;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        CompletableFuture<Integer> completableFuture = CompletableFuture.completedFuture(1);
//
//        System.out.println(completableFuture.get());
//
//        CompletableFuture<Integer> completableFuture1 = new CompletableFuture<>();
//
//        completableFuture1.completeExceptionally(new RuntimeException());
//
//        System.out.println(completableFuture1.complete(2));

        // CompletionStage에 대해서 이해하기

        CompletableFuture.runAsync(() -> {
            log.info("runAsync");


        })
                .thenRun(() -> log.info("thenRunAsync"))
                .thenRun(() -> log.info("thenRunAsync"));

        log.info("exit");

        ForkJoinPool.commonPool().shutdown();
        ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);


        CompletableFuture.supplyAsync(() -> {
            log.info("runAsync");

            return 1;
        })
                .thenApply(s -> {
                    log.info("thenApply : {}", s);

                    return s + 1;
                })
                .thenAccept(s2 -> {
                    log.info("Then Run : {}" , s2);
                })
                ;

        log.info("exit");

        ForkJoinPool.commonPool().shutdown();
        ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);


        CompletableFuture.supplyAsync(() -> {
            log.info("runAsync");

            return 1;
        })
                .thenCompose(s -> {
                    log.info("thenApply : {}", s);

                    return CompletableFuture.completedFuture(s + 1);
                })
                .thenAccept(s2 -> {


                    log.info("Then Run : {}" , s2);
                })
        ;

        log.info("exit");

        ForkJoinPool.commonPool().shutdown();
        ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);

        // 동일 스레드에서 작업이 일어나는 구조
        CompletableFuture.supplyAsync(() -> {
            log.info("runAsync");

            if( 1 == 1) throw new RuntimeException();

            return 1;
        })
                .thenCompose(s -> {
                    log.info("thenApply : {}", s);

                    return CompletableFuture.completedFuture(s + 1);
                })
                .exceptionally(e -> 10 )
                .thenAccept(s2 -> {


                    log.info("Then Run : {}" , s2);
                })
        ;

        log.info("exit");

        ForkJoinPool.commonPool().shutdown();
        ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Thread를 더 효율적으로
        // AWS에서는 Hyper Thread 교착이 존재한다.
        CompletableFuture.supplyAsync(() -> {
            log.info("runAsync");
            return 1;
        })
                .thenCompose(s -> {
                    log.info("thenApply : {}", s);

                    return CompletableFuture.completedFuture(s + 1);
                })
                .thenApplyAsync(s2 -> {
                    log.info("then Apply : {}", s2);
                    return s2 *3;
                }, executorService)
                .exceptionally(e -> 10 )
                .thenAcceptAsync(s2 -> {


                    log.info("Then Run : {}" , s2);
                }, executorService)
        ;

        log.info("exit");

        executorService.shutdown();

        ForkJoinPool.commonPool().shutdown();
        ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);

        // Tail Call - 재귀호출하는 방식 처리 가능
    }
}
