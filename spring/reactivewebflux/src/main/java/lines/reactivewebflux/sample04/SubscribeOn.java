package lines.reactivewebflux.sample04;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class SubscribeOn {
    public static void main(String[] args) {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        final Flux<String> flux = Flux
                .range(1, 100)
                .map(i -> { log.info("before subscribeOn : {} " , i); return 10 + i; })
                .subscribeOn(s)
                .map(i -> "Value " + i);

        new Thread(() -> flux.subscribe(item -> { log.info("value : {}" ,item); } )).start();
    }
}
