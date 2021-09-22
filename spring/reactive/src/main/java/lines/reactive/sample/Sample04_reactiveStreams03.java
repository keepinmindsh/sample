package lines.reactive.sample;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class Sample04_reactiveStreams03 {

    public static void main(String[] args) {
        Publisher publisher = getPublisher();

        Publisher processor = getProcessor(publisher);

        processor.subscribe(getSubscriber());
    }

    public static Publisher getPublisher(){
        return subscriber -> {
            subscriber.onSubscribe(new Subscription() {
                @Override
                public void request(long n) {
                    log.info("getPublisher : request");
                    subscriber.onNext("1번 값 을 호출합니다.");
                }

                public void cancel() {

                }
            });
        };
    }

    public static Publisher getProcessor(Publisher publisher){
        return subscriber -> {
            publisher.subscribe(new Subscriber() {

                @Override
                public void onSubscribe(Subscription subscription) {
                    subscriber.onSubscribe(subscription);
                }

                @Override
                public void onNext(Object o) {
                    log.info("getPublisherSecond : onNext");
                    log.info("onNext: {}" , o);
                    subscriber.onNext("2번 값 입니다.");
                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onComplete() {

                }
            });

        };
    }

    public static Subscriber getSubscriber(){
        return new Subscriber() {
            Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                log.info("getSubscriber : onSubscribe");
                log.info("Subscriber 를 초기화 합니다.");
                this.subscription = subscription;
                subscription.request(1);
            }

            @Override
            public void onNext(Object o) {
                log.info("Subscriber : onNext");
                log.info("onNext: {}" , o);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
    }
}
