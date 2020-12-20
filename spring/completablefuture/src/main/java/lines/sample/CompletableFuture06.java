package lines.sample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class CompletableFuture06 {

    public static void main(String[] args) throws Exception {
        combine();
    }

    public static void combine() throws Exception {
        Price price = new Price();
        // 각각의 CompletableFuture에서 호출한 프로세스에 대해서 각각 비동기적으로 실행디고 난 이후
        // 각각의 값을 조합해서 최종적인 결과값을 처리할 수 있다.

        /*
        * thenCombineAsync 는 아래와 같이 다수개의 Completable Future를 처리할 수 있는 구조이다.
        * a 값은 이전 Combine 데이터의 결과를 가져오는데, 이는 thenCombineAsync가 연속적으로 호출될 경우이다.
         */
        CompletableFuture<Double> price1 = price.getPriceAsync(1);
        CompletableFuture<Double> price2 = price.getPriceAsync(2);
        CompletableFuture<Double> price3 = price.getPriceAsync(3);
        price2.thenCombineAsync(price1, (a, b) -> {

                    log.info("a : {}" , a);
                    log.info("b : {}" , b);

                    return a + b;
                })
                .thenCombineAsync(price3, (a, b) -> {

                    log.info("a : {}" , a);
                    log.info("b : {}" , b);

                    return a + b;
                })
                .thenAcceptAsync(System.out::print);

        System.out.println("Non Blocking!!");

        // main thread 가 죽으면 child 도 다 죽어 버려서 대기함.
        Thread.sleep(5000l);
    }

    static class Price {
        public double getPrice(double oldprice) throws Exception {
            return calculatePrice(oldprice);
        }

        public double calculatePrice(double oldprice) throws Exception {
            System.out.println("Input :" + oldprice);
            Thread.sleep(1000l);
            System.out.println("Output :" + (oldprice + 1l));
            return oldprice + 1l;
        }

        public CompletableFuture<Double> getPriceAsync(double oldPrice) {
            CompletableFuture<Double> completableFuture = new CompletableFuture<>();
            new Thread(() -> {
                try {
                    double price = calculatePrice(oldPrice);
                    completableFuture.complete(price);
                } catch (Exception ex) {
                    completableFuture.completeExceptionally(ex);
                }
            }).start();

            return completableFuture;
        }
    }
}

