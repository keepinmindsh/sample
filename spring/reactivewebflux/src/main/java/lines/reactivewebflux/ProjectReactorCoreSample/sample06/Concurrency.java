package lines.reactivewebflux.ProjectReactorCoreSample.sample06;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class Concurrency {
    public static void main(String[] args) {
        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> i * 2)
                .subscribeOn(Schedulers.parallel())
                .subscribe( item -> {
                    log.info("Spring Data : {}" , item);
                });
    }
}
