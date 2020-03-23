package lines.reactive.sample.sample12;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class CustomSubscriber<T,R> implements Subscriber<T> {

    private Subscriber subscriber;

    public CustomSubscriber(Subscriber<? super R> subscriber){
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscriber.onSubscribe(subscription);
    }

    @Override
    public void onNext(T integer) {
        subscriber.onNext(integer);
    }

    @Override
    public void onError(Throwable t) {
        subscriber.onError(t);
    }

    @Override
    public void onComplete() {
        subscriber.onComplete();
    }
}
