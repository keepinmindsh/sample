package lines.reactive.sample.sample17;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Take {

    public static void main(String[] args) {

        Publisher<Integer> publisher = new Publisher<Integer>() {

            private boolean isCancelled = false;
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Subscription() {

                    @Override
                    public void request(long n) {
                        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

                        executorService.scheduleAtFixedRate(() -> {

                            if(isCancelled){
                                executorService.shutdown();
                                return;
                            }

                            subscriber.onNext(1);
                        }, 1,1, TimeUnit.SECONDS);
                    }

                    @Override
                    public void cancel() {
                        isCancelled = true;
                    }
                });
            }
        };

        Publisher<Integer> operator = new Publisher<Integer>() {


            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {


                publisher.subscribe(new Subscriber<Integer>() {
                    private int count;
                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscriber.onSubscribe(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        subscriber.onNext(count);
                        count += integer;

                        if(count > 10){
                            subscription.cancel();
                            return;
                        }
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

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("On Next - Result : " + integer);
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
