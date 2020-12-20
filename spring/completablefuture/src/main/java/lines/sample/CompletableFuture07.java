package lines.sample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class CompletableFuture07 {
    public static void main(String[] args) throws Exception {

        testCase0ForFutureGet();

        testCase1ForthenApply();

        testCase2ForthenAccept();

        testCase3ForthenRun();

        testCase4ForthenCompose();

        testCase5ForthenCombine();

        testCase6ForthenAcceptBoth();
    }

    private static void testCase6ForthenAcceptBoth() {
        CompletableFuture.supplyAsync(() -> "Test Case 6")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " For thenAcceptBoth"), (s1, s2) -> log.info("Result :{}" , s1 + s2));
    }

    private static void testCase5ForthenCombine() {
        CompletableFuture.supplyAsync(() -> "Test Case 5")
                .thenCombine(CompletableFuture.supplyAsync(() -> " : thenCombine"), ( s1, s2 ) -> s1 + s2)
                .thenAccept(s -> log.info("Reulst {} by then Accept", s));
    }

    private static void testCase4ForthenCompose() throws InterruptedException, ExecutionException {
        log.info("Test Case 4 for thenCompose : {}", CompletableFuture.supplyAsync(() -> "Test Case4")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " thenCompose"))
                .get());
    }

    private static void testCase3ForthenRun() {
        CompletableFuture.supplyAsync(() -> {
            log.info("Test Case 4");

            return "Test Case 4";
        }).thenRun(() -> {
            log.info("thenRun without return and parameter");
        });
    }

    private static void testCase2ForthenAccept() {
        CompletableFuture.supplyAsync(() -> {
            log.info("Call Test 01");

            return "Call Test";
        })
                // Completable Future을 통해서 연산된 값을 즉시 사용하고 싶은 경우에 적용 가능하다.
                .thenAccept((a) -> {

            log.info("thenAccept는 값을 받지 않고 즉시 실행하는 경우에 사용한다 : {}", a);
        });
    }

    private static void testCase0ForFutureGet() throws InterruptedException, ExecutionException {
        CompletableFuture
                .supplyAsync(() -> {

                    new Thread(){
                        @Override
                        public void run() {

                            log.info("Thread Call !!");
                        }
                    }.start();

                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }

                    return "1000";
                })
                // thenApply의 경우, 적용후에 해당 값을 Future의 get을 이용해서 가져와야 한다.
                .thenApply((a) -> {

                    log.info("result : {}", a);

                    return a;
                }).get();
    }

    private static void testCase1ForthenApply() throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future = completableFuture.thenApply(s -> s + "World");

        log.info("Result : {}", future.get());
    }
}
