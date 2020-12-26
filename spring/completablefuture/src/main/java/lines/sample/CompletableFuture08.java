package lines.sample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@Slf4j
public class CompletableFuture08 {
    public static void main(String[] args) {
        CompletableFuture completableFuture = new CompletableFuture();

        completableFuture.whenComplete(new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                log.info("Message : {}", "TEST");
            }
        });

        completableFuture.complete(new Object());
    }
}
