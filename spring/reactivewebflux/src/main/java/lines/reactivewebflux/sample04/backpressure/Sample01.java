package lines.reactivewebflux.sample04.backpressure;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

@Slf4j
public class Sample01 {
    public static void main(String[] args) {
        Flux.just(1,2,3,4,5,6)
                .log()
                .subscribe(new Subscriber<Integer>() {
                    private Subscription subscription;
                    int onNextAmount;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscription.request(2);
                    }

                    @SneakyThrows
                    @Override
                    public void onNext(Integer integer) {

                        log.info("Reactive Systems :{}", integer);

                        onNextAmount ++;
                        if(onNextAmount % 2 == 0){
                            Thread.sleep(5000);
                            subscription.request(2);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
