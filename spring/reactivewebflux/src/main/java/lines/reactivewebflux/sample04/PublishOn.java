package lines.reactivewebflux.sample04;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class PublishOn {
    public static void main(String[] args) {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        final Flux<String> flux = Flux
                .range(1, 100)
                .map(i -> { log.info("before publishOn : {} " , i); return 10 + i; })
                .publishOn(s)
                .map(i -> "value " + i);

        new Thread(() -> flux.subscribe(item -> {
            log.info(item);
        })).start();
    }
}
