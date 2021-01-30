package lines.reactive.sample.sample34;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;

@Slf4j
public class FluxSample {
    public static void main(String[] args) {
        Flux.fromIterable(getSomeLongList())
            .delayElements(Duration.ofMillis(100))
                .doOnNext(ServiceA::observer)
                .log()
                .map(value -> {

                    log.info("Value Added : {}", value + 2 );

                    return value + 2;
                } )
                .take(3)
                .onErrorResume(error -> {

                    log.info(error.getMessage());

                    return null;
                })
                .doAfterTerminate(() -> {
                    log.info("do After Terminate!");
                })
                .subscribe(System.out::println);
    }

    private static Iterable<Long> getSomeLongList(){
        return Arrays.asList(10L, 20L, 40L, 50L);
    }
}

@Slf4j
class ServiceA {
    public static Long observer(Long value){
        log.info("Value : {}", value);

        return value;
    }
}
