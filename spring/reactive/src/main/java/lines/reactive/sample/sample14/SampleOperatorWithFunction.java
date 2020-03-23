package lines.reactive.sample.sample14;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleOperatorWithFunction {

    public static void main(String[] args) {

        List<Integer> arrayInteger = Stream.iterate(1, i -> i * 2).limit(5).collect(Collectors.toList());

        Function<Integer, Integer> function = i -> i * 10 ;

        Publisher<Integer> publisher = getPublisher(arrayInteger, function);

        Function<Integer, Integer> minus = i -> i - 5;

        Publisher<Integer> operatorMinus = getOperatorMinus(publisher, minus);

        Subscriber<Integer> subscriber = getSubscriber();

        operatorMinus.subscribe(subscriber);
    }

    private static Subscriber<Integer> getSubscriber() {
        return new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("getSubscriber - OnNext : " + integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    private static Publisher<Integer> getOperatorMinus(Publisher<Integer> publisher, Function<Integer, Integer> minus) {
        return new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                publisher.subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        subscriber.onSubscribe(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("getOperatorMinus - onNext : " + integer);
                        subscriber.onNext(minus.apply(integer));
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

    private static Publisher<Integer> getPublisher(List<Integer> arrayInteger, Function<Integer, Integer> function) {
        return new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        arrayInteger.forEach(intVal -> {
                            subscriber.onNext(function.apply(intVal));
                        });
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };
    }
}
