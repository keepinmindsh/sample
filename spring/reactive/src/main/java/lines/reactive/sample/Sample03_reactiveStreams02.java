package lines.reactive.sample;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class Sample03_reactiveStreams02 {

    private static final int InitialExecuteCount = 50;

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    private static ExecutorService executorServiceForReactive = Executors.newFixedThreadPool(100);
    private static ScheduledExecutorService executorServiceForStarter = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1000);

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    blockingQueue.add("Queue" + i);
                }
            }
        }, 0, 10, TimeUnit.SECONDS);





        Publisher publisher = subscriber -> {
            subscriber.onSubscribe(new Subscription() {
                @Override
                public void request(long executeCount) {
                    log.info("Publisher request의 사이즈 : {}", executeCount);

                    List<Future> futureList= new ArrayList<>();

                    for (int i = 0; i < executeCount; i++) {
                        futureList.add(executorServiceForReactive.submit(() -> log.info(blockingQueue.poll())));
                    }

                    futureList.forEach(future -> {
                        try {
                            future.get();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

                    if(blockingQueue.isEmpty()){
                        subscriber.onComplete();
                    }else{
                        int size = blockingQueue.size();
                        log.info("Blocking Queue의 사이즈 : {}", size);
                        subscriber.onNext(Long.parseLong(String.valueOf(size)) );
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
                log.info("Subscriber - OnNext : {}" , executeCount);
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


}
