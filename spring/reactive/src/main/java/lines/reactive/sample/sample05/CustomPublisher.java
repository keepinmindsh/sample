package lines.reactive.sample.sample05;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CustomPublisher<Command> implements Publisher<Command> {

    private final BlockingQueue<Command> blockingQueue;

    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public CustomPublisher(BlockingQueue<Command> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void subscribe(Subscriber<? super Command> subscriber) {
        subscriber.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                while (!blockingQueue.isEmpty()) {
                    try {
                        Command command = blockingQueue.take();

                        subscriber.onNext(command);

                    } catch (InterruptedException e) {
                        // Exception handling.
                    }
                }

                executorService.schedule(() -> {
                    if(Counter.get() == 2000){
                        System.out.println("onComplete");
                        subscriber.onComplete();

                        executorService.shutdown();
                    }
                }, 1, TimeUnit.SECONDS);
            }

            @Override
            public void cancel() {

            }
        });
    }
}
