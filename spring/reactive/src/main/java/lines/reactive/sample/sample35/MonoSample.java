package lines.reactive.sample.sample35;

import reactor.core.publisher.Mono;

import java.time.Duration;

public class MonoSample {
    public static void main(String[] args) {
        Mono.just(1L)
                .map(integer -> integer)
                .or(Mono.delay(Duration.ofMillis(100)))
                .subscribe(System.out::println);

    }
}
