package lines.reactivewebflux.ProjectReactorCoreSample.sample05;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxSample {
    public static void main(String[] args) {
        Flux<String> stringFlux = Flux.just("1", "2", "3");

        stringFlux.map(i -> {
            return i + 10;
        }).flatMap(i -> {
            Flux.just(i).subscribe(item -> log.info("Value : {}", item));

            return Flux.just(i);
        })
        .log()
        .subscribe(item -> {
            log.info("Flux Value : {}", item);
        });


        stringFlux.map(i -> {
            return i + 10;
        })
        .log()
        .subscribe(item -> {
            log.info("Flux Value : {}", item);
        });
    }
}
