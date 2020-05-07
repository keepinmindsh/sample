package lines.reactivewebflux.sample04;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

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
    }
}
