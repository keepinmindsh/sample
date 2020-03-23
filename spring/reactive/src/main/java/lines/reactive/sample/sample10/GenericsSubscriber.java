package lines.reactive.sample.sample10;

import lines.reactive.sample.sample10.command.Command;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class GenericsSubscriber<T extends Command> implements Subscriber<T> {

    private Subscription subscription;
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;

        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T command) {
        command.execute();
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
