package sample.Reactive.basic02;


import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicSample {
    public static void main(String[] args) {

        List<Integer> integerList = Stream.iterate(0, a -> a + 1 )
                .limit(200)
                .collect(Collectors.toList());

        Publisher<Integer> publisher = new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {

                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {

                        int rowCount = integerList.size();

                        for (int i = 0; i < rowCount; i++) {
                            subscriber.onNext(integerList.get(i));
                        }

                        subscriber.onComplete();
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {

            Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;

                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("On Next");

                System.out.println(integer);

                //if(integer == 100){
                //    subscription.request(Long.MAX_VALUE);
                //}
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("On Error");
            }

            @Override
            public void onComplete() {
                System.out.println("On Complete");
            }
        };

        publisher.subscribe(subscriber);
    }
}
