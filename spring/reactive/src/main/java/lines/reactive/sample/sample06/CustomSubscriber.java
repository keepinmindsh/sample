package lines.reactive.sample.sample06;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomSubscriber implements Subscriber<Command> {

    private ExecutorService executorService = Executors
            .newFixedThreadPool(1000);

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Command command) {
        executorService.execute(command::work);
    }

    @Override
    public void onError(Throwable throwable) {
        subscription.cancel();
    }

    @Override
    public void onComplete() {
        if(!executorService.isShutdown()){
            executorService.shutdown();
        }
    }
}
