package lines.reactive.sample.sample18;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class PubSubOn {

    public static void main(String[] args) {

        Publisher<Integer> publisher = new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        System.out.println("On Request");

                        subscriber.onNext(1);
                        subscriber.onNext(2);
                        subscriber.onNext(3);
                        subscriber.onNext(4);
                        subscriber.onNext(5);
                        subscriber.onComplete();

                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        // Publisher의 수행이 느린 경우,
        Publisher<Integer> subscribeOn = new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                ExecutorService executorService = Executors.newSingleThreadScheduledExecutor(new CustomizableThreadFactory(){
                    @Override
                    public String getThreadNamePrefix() {
                        return "subOn";
                    }
                });

                executorService.execute(() -> {
                   publisher.subscribe(subscriber);
                });

                log.info("subscribeOn Call");

                executorService.shutdown();
            }
        };


        Publisher<Integer> publishOn = new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                subscribeOn.subscribe(new Subscriber<Integer>() {


                    ExecutorService executorService = Executors.newSingleThreadExecutor(new CustomizableThreadFactory(){
                        @Override
                        public String getThreadNamePrefix() {
                            return "PubOn";
                        }
                    });

                    @Override
                    public void onSubscribe(Subscription s) {
                        subscriber.onSubscribe(s);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        executorService.execute(() -> {
                            subscriber.onNext(integer);
                        });

                    }

                    @Override
                    public void onError(Throwable t) {
                        executorService.execute(() -> {
                            subscriber.onError(t);
                        });
                        executorService.shutdown();
                    }

                    @Override
                    public void onComplete() {
                        executorService.execute(() -> {
                            subscriber.onComplete();
                        });
                        executorService.shutdown();
                    }
                });
            }
        };

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("On Next : " + integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println("On Compleate : 완료됨 ");
            }
        };

        publishOn.subscribe(subscriber);
    }
}
