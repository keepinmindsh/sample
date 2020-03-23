package lines.reactive.sample.sample13;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleOperators {

    public static void main(String[] args) {

        List<Integer> list = Stream.iterate(0, a -> a + 1).limit(100).collect(Collectors.toList());

        Publisher<Integer> publisher = getPublisher(list);

        Publisher<Integer> operator = getOperator(publisher);

        Subscriber<Integer> subscriber = getSubscriber();

        operator.subscribe(subscriber);

    }

    private static Publisher getPublisher(List<Integer> list) {
        return new Publisher(){
            @Override
            public void subscribe(Subscriber subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        list.forEach(integerItem -> {
                            subscriber.onNext(integerItem);
                        });
                    }

                    @Override
                    public void cancel() {

                    }
                });

            }
        };
    }

    private static Publisher<Integer> getOperator(Publisher operator) {
        return new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                operator.subscribe(new Subscriber<Integer>(){
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        subscriber.onSubscribe(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {

                        int value = integer + 10;

                        subscriber.onNext(value);
                    }

                    @Override
                    public void onError(Throwable t) {
                        subscriber.onError(t);
                    }

                    @Override
                    public void onComplete() {
                        subscriber.onComplete();
                    }
                });
            }
        };
    }

    private static Subscriber<Integer> getSubscriber() {
        return new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext 결과 값 : " + integer);
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
