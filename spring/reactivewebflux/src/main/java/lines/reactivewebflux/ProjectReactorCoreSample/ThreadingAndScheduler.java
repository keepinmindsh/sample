package lines.reactivewebflux.ProjectReactorCoreSample;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
public class ThreadingAndScheduler {
    public static void main(String[] args) throws Exception {
        final Mono<String> mono = Mono.just("hello ");

        Thread t = new Thread(() -> mono
                .map(msg -> msg + "thread ")
                .subscribe(v ->
                        log.info(v + Thread.currentThread().getName())
                )
        );
        t.start();
        t.join();

        Flux.interval(Duration.ofMillis(300), Schedulers.newSingle("test")).log().limitRequest(100).subscribe(item -> log.info("It is test"));
    }
}
