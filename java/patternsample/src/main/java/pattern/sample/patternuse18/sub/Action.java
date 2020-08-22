package pattern.sample.patternuse18.sub;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import pattern.sample.patternuse18.unit.Unit;

import java.util.List;

public class Action implements Subscriber<List<Unit>> {
    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(1);
    }

    @Override
    public void onNext(List<Unit> list) {
        list.forEach(unit -> {
            unit.act();
        });
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
