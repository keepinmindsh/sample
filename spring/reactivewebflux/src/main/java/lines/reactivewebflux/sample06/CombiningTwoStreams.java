package lines.reactivewebflux.sample06;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class CombiningTwoStreams {
    public static void main(String[] args) {
        Flux.just(1,2,3,4,10,11,123,14345)
                .log()
                .map(i -> i * 2)
                .zipWith(Flux.range(0,3),
                        (one, two) -> String.format("First Fluxe : %d , Second Flux : %d ", one, two))
                .subscribe(item -> log.info("Spring Data : {}", item));
    }
}
/*
        17:45:20.016 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
        17:45:20.046 [main] INFO reactor.Flux.Array.1 - | onSubscribe([Synchronous Fuseable] FluxArray.ArraySubscription)
        17:45:20.050 [main] INFO reactor.Flux.Array.1 - | request(32)
        17:45:20.050 [main] INFO reactor.Flux.Array.1 - | onNext(1)
        17:45:20.050 [main] INFO reactor.Flux.Array.1 - | onNext(2)
        17:45:20.050 [main] INFO reactor.Flux.Array.1 - | onNext(3)
        17:45:20.050 [main] INFO reactor.Flux.Array.1 - | onNext(4)
        17:45:20.050 [main] INFO reactor.Flux.Array.1 - | onNext(10)
        17:45:20.050 [main] INFO reactor.Flux.Array.1 - | onNext(11)
        17:45:20.050 [main] INFO reactor.Flux.Array.1 - | onNext(123)
        17:45:20.050 [main] INFO reactor.Flux.Array.1 - | onNext(14345)
        17:45:20.051 [main] INFO reactor.Flux.Array.1 - | onComplete()
        17:45:20.053 [main] INFO lines.reactivewebflux.sample06.CombiningTwoStreams - Spring Data : First Fluxe : 2 , Second Flux : 0
        17:45:20.053 [main] INFO lines.reactivewebflux.sample06.CombiningTwoStreams - Spring Data : First Fluxe : 4 , Second Flux : 1
        17:45:20.053 [main] INFO lines.reactivewebflux.sample06.CombiningTwoStreams - Spring Data : First Fluxe : 6 , Second Flux : 2
        17:45:20.053 [main] INFO reactor.Flux.Array.1 - | cancel()
*/
