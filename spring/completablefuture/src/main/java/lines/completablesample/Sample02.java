package lines.completablesample;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Sample02 {
    // 동시에 n개의 요청을 호출하고 하나라도 호출이 완성되면 진행하기
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(Sample02::buildMessage);
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(Sample02::buildMessage);
        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(Sample02::buildMessage);

        List<CompletableFuture<String>> completableFutures = Arrays.asList(completableFuture1, completableFuture2, completableFuture3);

        CompletableFuture
                .allOf(completableFutures.toArray(new CompletableFuture[3]))
                .thenAcceptAsync(result -> log.info("Result : {}", result));

        Thread.sleep(11 * 1000L);

    }

    private static String buildMessage(){
        try {
            Thread.sleep(5 * 1000L);
        }catch (Exception exception){
            exception.getMessage();

            log.error(exception.getMessage());
        }

        return "Complete";
    }
}
