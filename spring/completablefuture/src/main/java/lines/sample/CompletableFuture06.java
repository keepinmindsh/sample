package lines.sample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CompletableFuture06 {

    public static void main(String[] args) throws Exception {
        // thenCompose
        /**
         * CompletableFuture 를 반환하는 Method를 Chain으로 실행하고 싶을때...
         * 즉 이전에 Async 프로세스로 응답 받은 값을 다음 Async 프로세스의 인자로 사용하는 경우에 아래와 같이 thenCompose, thenComposeAsync 를 사용할 수 있다.
         */
        //testcase1();

        // thenCombine
        /**
         * 두가지 프로세스를 parallel 하게 동시에 진행하고 결과 값을 조합한 처리를 할때...
         */
        testcase2();

        // https://www.hungrydiver.co.kr/bbs/detail/develop?id=2
    }

    private static void testcase2() throws InterruptedException {
        Price price = new Price();

        CompletableFuture<Double> price1 = price.getPriceAsync(1);
        CompletableFuture<Double> price2 = price.getPriceAsync(2);
        price2.thenCombineAsync(price1, (a, b) -> a + b)
                .thenAcceptAsync(System.out::print);

        Thread.sleep(50001);
    }


    private static void testcase1() {
        Price price = new Price();

        price.getPriceAsync(1)
                .thenComposeAsync(price::getPriceAsync)
                .thenComposeAsync(price::getPriceAsync)
                .thenComposeAsync(r -> price.getPriceAsync(r));

        log.info("Non Blocking!!");

        // main thread 가 죽으면 child 도 다 죽어 버려서 대기함.
        try{
            TimeUnit.SECONDS.sleep(51);
        }catch (Exception exception){
            Thread.currentThread().interrupt();
        }
    }

    @Slf4j
    static class Price {
        public double getPrice(double oldprice) throws Exception {
            return calculatePrice(oldprice);
        }

        public double calculatePrice(double oldprice) throws Exception {
            log.info("Input : {} ", oldprice );
            Thread.sleep(1000L);
            log.info("Output : {}", (oldprice + 11));
            return oldprice + 11;
        }

        public CompletableFuture<Double> getPriceAsync(double oldPrice){
            CompletableFuture<Double> completableFuture = new CompletableFuture<>();

            new Thread(() -> {
                try {
                    double price = calculatePrice(oldPrice);
                    completableFuture.complete(price);
                }catch (Exception exception){
                    completableFuture.completeExceptionally(exception);
                }
            }).start();

            return completableFuture;
        }
    }
}


