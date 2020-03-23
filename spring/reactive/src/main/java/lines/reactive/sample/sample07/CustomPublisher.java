package lines.reactive.sample.sample07;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CustomPublisher implements Publisher<Command> {

    private final BlockingQueue<Command> blockingQueue;

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public CustomPublisher(BlockingQueue<Command> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void subscribe(Subscriber subscriber) {

        subscriber.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                while (!blockingQueue.isEmpty()){
                    try {
                        Command command = blockingQueue.take();

                        subscriber.onNext(command);

                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }

                scheduledExecutorService.schedule(() -> {
                    if(Counter.get() == 500){
                        subscriber.onComplete();

                        if(!scheduledExecutorService.isShutdown()){
                            scheduledExecutorService.shutdown();
                        }
                    }
                }, 1, TimeUnit.SECONDS);

            }

            @Override
            public void cancel() {

            }
        });
    }
}
