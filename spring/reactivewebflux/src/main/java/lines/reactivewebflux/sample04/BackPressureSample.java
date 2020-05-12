package lines.reactivewebflux.sample04;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class BackPressureSample {
    public static void main(String[] args) {

        Flux.range(1, 10)
                .doOnRequest(item -> log.info("Values {} : " ,item) )
                .subscribe(new BaseSubscriber<Integer>(){
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        log.info("Cancelling after having received " + value);
                        cancel();
                    }
                });


        Flux.range(1, 60000)
                .doOnRequest(item -> log.info("Value : {}", item))
                .parallel(10)
                .log()
                .subscribe(new BaseSubscriber<Integer>() {

                    AtomicInteger atomicInteger = new AtomicInteger();

                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(10);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {

                        log.info("Value Final : {}", value);

                        int intValue = atomicInteger.incrementAndGet();

                        if(intValue % 10 == 0){
                            request(10);
                        }
                    }
                });
    }
}
