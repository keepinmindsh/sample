package lines.reactive.sample;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.*;

public class Sample03_reactiveStreams02 {

    private static final int InitialExecuteCount = 50;

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    private static ExecutorService executorServiceForReactive = Executors.newFixedThreadPool(100);
    private static ScheduledExecutorService executorServiceForStarter = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1000);

        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    blockingQueue.add("Queue" + i);
                }
            }
        }, 0, 10, TimeUnit.SECONDS);



        executorServiceForStarter.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {

                Publisher publisher = subscriber -> {
                    subscriber.onSubscribe(new Subscription() {
                        @Override
                        public void request(long executeCount) {

                            for (int i = 0; i < executeCount; i++) {
                                executorServiceForReactive.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        System.out.println(blockingQueue.poll());
                                    }
                                });
                            }

                            if(blockingQueue.isEmpty()){
                                subscriber.onComplete();
                            }else{
                                subscriber.onNext(blockingQueue.size());
                            }
                        }

                        @Override
                        public void cancel() {

                        }
                    });
                };

                Subscriber subscriber = new Subscriber() {

                    Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {

                        this.subscription = subscription;

                        subscription.request(InitialExecuteCount);
                    }

                    @Override
                    public void onNext(Object executeCount) {
                        subscription.request((Long)executeCount);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                };

                publisher.subscribe(subscriber);
            }
        }, 0, 5, TimeUnit.SECONDS);
    }
}
