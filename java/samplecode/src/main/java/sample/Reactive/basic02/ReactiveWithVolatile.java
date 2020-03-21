package sample.Reactive.basic02;


import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReactiveWithVolatile {

    private static volatile String testData = "";

    private static ScheduledExecutorService executorScheduler = Executors.newSingleThreadScheduledExecutor();
    private static ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {

        executorScheduler.scheduleAtFixedRate(() -> {
            testData = testData + "0" ;
        }, 1, 1, TimeUnit.SECONDS);

        Publisher<String> publisher = new Publisher<String>() {
            @Override
            public void subscribe(Subscriber<? super String> subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        for (int i = 0; i < n; i++) {
                            executorService.execute(() -> {
                                subscriber.onNext(testData);
                            });
                        }

                        subscriber.onComplete();
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        Subscriber<String> subscriber = new Subscriber<String>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {

                this.subscription = subscription;

                subscription.request(3);
            }

            @Override
            public void onNext(String s) {
                System.out.println("--------------------Start------------------------");
                System.out.println(Thread.currentThread().getName() + " : onNext 호출");
                System.out.println(Thread.currentThread().getName() + " : " + s);
                System.out.println("---------------------End-------------------------");
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                subscription.request(3);
            }
        };

        publisher.subscribe(subscriber);
    }
}
