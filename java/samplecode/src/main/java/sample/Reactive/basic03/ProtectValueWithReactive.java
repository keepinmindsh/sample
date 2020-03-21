package sample.Reactive.basic03;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProtectValueWithReactive {

    private static ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {

        ValueMananger valueMananger = new ValueMananger();

        Publisher<Integer> publisher = new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        for (int i = 0; i < n; i++) {
                            executorService.execute(() -> {
                                subscriber.onNext(valueMananger.getTestValue());
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

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {

                this.subscription = subscription;

                subscription.request(10);

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("----------Start-----------");
                System.out.println(integer);
                System.out.println("-----------End------------");
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                subscription.request(10);

            }
        };

        publisher.subscribe(subscriber);
    }
}

class ValueMananger {
    private Lock lockForProtect = new ReentrantLock();
    private int value = 0;

    public int getTestValue(){
        lockForProtect.lock();

        value ++;

        lockForProtect.unlock();

        return value;
    }

}
