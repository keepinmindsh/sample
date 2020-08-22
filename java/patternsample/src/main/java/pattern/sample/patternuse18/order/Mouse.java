package pattern.sample.patternuse18.order;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import pattern.sample.patternuse18.unit.Unit;

import java.util.List;

public class Mouse implements Publisher<List<Unit>> {

    private final List<Unit> unitList;

    public Mouse(List<Unit> list) {
        this.unitList = list;
    }


    @Override
    public void subscribe(Subscriber<? super List<Unit>> subscriber) {
        subscriber.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                subscriber.onNext(unitList);
            }

            @Override
            public void cancel() {

            }
        });
    }
}
