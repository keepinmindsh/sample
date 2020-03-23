package lines.reactive.sample;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Sample04_reactiveStreams03 {


    public static void main(String[] args) {
        Publisher publisher = getPublisher();

        Publisher publisher1 = getPublisherSecond(publisher);

        publisher1.subscribe(getSubscriber());
    }

    public static Publisher getPublisher(){
        return subscriber -> {
            subscriber.onSubscribe(new Subscription() {
                @Override
                public void request(long n) {
                    System.out.println("getPublisher : request");

                    subscriber.onNext("1번 값 을 호출합니다.");
                }

                @Override
                public void cancel() {

                }
            });
        };
    }

    public static Publisher getPublisherSecond(Publisher publisher){
        return subscriber -> {
            publisher.subscribe(new Subscriber() {

                @Override
                public void onSubscribe(Subscription subscription) {
                    subscriber.onSubscribe(subscription);
                }

                @Override
                public void onNext(Object o) {
                    System.out.println("getPublisherSecond : onNext");
                    System.out.println(o);
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
                System.out.println("getSubscriber : onSubscribe");
                System.out.println("Subscriber 를 초기화 합니다.");
                this.subscription = subscription;
                subscription.request(1);
            }

            @Override
            public void onNext(Object o) {
                System.out.println("Subscriber : onNext");
                System.out.println(o);
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
