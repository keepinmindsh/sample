package lines.reactive.sample.sample05;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomSubscriber implements Subscriber<Command> {

    private Subscription subscription;

    private final ExecutorService executorService = Executors.newFixedThreadPool(1000);

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;

        this.subscription.request(1);
    }

    @Override
    public void onNext(Command command) {
        executorService.execute(command::work);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("We Error");
    }

    @Override
    public void onComplete() {
        System.out.println("We Finished");

        executorService.shutdown();
    }
}
