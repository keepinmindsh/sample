package lines.reactivewebflux.ProjectReactorCoreSample;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

@Slf4j
public class SampleSubscriber {

    public static void main(String[] args) {
        SampleSubscriberTest<Integer> ss = new SampleSubscriberTest<Integer>();
        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(i -> log.info("Value : {}", i),
                error -> log.error("Error : {} ", error),
                () -> {log.info("Done");},
                s -> s.request(10));
        ints.subscribe(ss);
    }

    public static class SampleSubscriberTest<T> extends BaseSubscriber<T> {

        public void hookOnSubscribe(Subscription subscription) {
            log.info("Subscribed");
            request(1);
        }

        public void hookOnNext(T value) {
            log.info("Value 2th : {} " , value);
            request(1);
        }
    }
}

