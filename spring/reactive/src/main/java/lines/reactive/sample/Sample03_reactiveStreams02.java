package lines.reactive.sample;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Sample03_reactiveStreams02 {

    private static final int InitialExecuteCount = 50;

    private static final ExecutorService executorServiceForReactive = Executors.newFixedThreadPool(5);
    private static final AtomicInteger counting = new AtomicInteger();

    public static void main(String[] args) {

        counting.set(1);

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1000);

        makingBlockingQueue(blockingQueue);

        Publisher publisher = getPublisher(blockingQueue);

        Subscriber subscriber = getSubscriber();

        publisher.subscribe(subscriber);
    }

    private static Subscriber getSubscriber() {
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

                int rowCnt = Integer.parseInt(String.valueOf(executeCount));

                for (int i = 0; i < rowCnt ; i++) {
                    log.info("Execute : {}", i);
                }

                subscription.request((Integer)executeCount);
            }

            @Override
            public void onError(Throwable t) { }

            @Override
            public void onComplete() {
                if(!executorServiceForReactive.isShutdown()){
                    executorServiceForReactive.shutdown();
                }
            }
        };
        return subscriber;
    }

    private static Publisher getPublisher(BlockingQueue<String> blockingQueue) {
        Publisher publisher = subscriber -> {
            subscriber.onSubscribe(new Subscription() {
                @Override
                public void request(long executeCount) {
                    log.info("Publisher request의 사이즈 : {}", executeCount);

                    List<Future> futureList= new ArrayList<>();

                    for (int i = 0; i < executeCount; i++) {
                        futureList.add(executorServiceForReactive.submit(() -> {
                            blockingQueue.poll();
                        }));
                    }

                    futureList.forEach(future -> {
                        try {
                            future.get();
                        } catch (Exception exception) {
                            log.error(exception.getMessage());
                            exception.printStackTrace();
                        }
                    });

                    if(blockingQueue.isEmpty()){
                        subscriber.onComplete();
                    }else{
                        log.info("Blocking Queue의 사이즈 : {}", InitialExecuteCount * counting.incrementAndGet());
                        subscriber.onNext(Integer.parseInt(String.valueOf(InitialExecuteCount)));
                    }
                }

                @Override
                public void cancel() { }
            });
        };
        return publisher;
    }

    private static void makingBlockingQueue(BlockingQueue<String> blockingQueue) {
        for (int i = 0; i < 920; i++) {
            blockingQueue.add("Queue" + i);
        }
    }
}
