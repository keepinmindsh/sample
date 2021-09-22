package lines.reactive.sample.sample19;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class FluxSample {
    public static void main(String[] args) {

        Flux.range(1, 10)
                .publishOn(Schedulers.newSingle("pub"))
                .log()
                .subscribeOn(Schedulers.newSingle("sub"))
                .subscribe(System.out::println);

        System.out.println("Exit");

        // Daemon Thread
        Flux.interval(Duration.ofMillis(100))
                .take(10)
                .subscribe(System.out::println);
    }
}
