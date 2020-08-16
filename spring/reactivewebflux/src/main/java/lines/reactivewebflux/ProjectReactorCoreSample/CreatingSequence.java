package lines.reactivewebflux.ProjectReactorCoreSample;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class CreatingSequence {
    public static void main(String[] args) {
        Flux<String> stringFlux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if( state == 10) sink.complete();
                    return state + 1;
                }
        );

        stringFlux.subscribe(item -> log.info("Generated Value : {}" , item) );


        Flux<String> stringFlux1 = Flux.generate(
                AtomicLong::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next(" 3 x " + i + " = " + 3 * i);
                    if( i == 10 ) sink.complete();
                    return state;
                });

        stringFlux1.subscribe(item -> log.info("Generated Value : {} " , item ));


        Flux<String> stringFlux2 = Flux.generate(
                AtomicLong::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next(" 3 x " + i + " = " + 3 * i);
                    if( i == 10 ) sink.complete();
                    return state;
                }, (state) -> log.info("state: {} ", state));

        stringFlux2.subscribe(item -> log.info("Generated Value : {} " , item ));


    }
}
