package lines.reactive.sample.sample16;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PublisherOn {
    public static void main(String[] args) {

        List<Integer> arrayList = Stream.iterate(1 , i -> i + 1).limit(100).collect(Collectors.toList());

        // Subscriber 가 아주 느린 경우에 이를 사용하는 방식이다.
        Publisher<Integer> publisher = subscriber -> subscriber.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                arrayList.forEach(integer -> {
                    subscriber.onNext(integer);
                });

                subscriber.onComplete();
            }

            @Override
            public void cancel() {

            }
        });

        Publisher<Integer> operator = new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {

                    publisher.subscribe(new Subscriber<Integer>() {

                        ExecutorService executorService = Executors.newSingleThreadExecutor();

                        @Override
                        public void onSubscribe(Subscription subscription) {
                            subscriber.onSubscribe(subscription);
                        }

                        @Override
                        public void onNext(Integer integer) {
                            executorService.execute(() -> { subscriber.onNext(integer);   });
                        }

                        @Override
                        public void onError(Throwable t) {
                            executorService.execute(() -> { subscriber.onError(t); });
                            executorService.shutdown();
                        }

                        @Override
                        public void onComplete() {
                            executorService.execute(() -> { subscriber.onComplete(); });
                            executorService.shutdown();
                        }

                });

            }
        };

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(Thread.currentThread().getName() + " OnNext : " + integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        operator.subscribe(subscriber);

    }
}
