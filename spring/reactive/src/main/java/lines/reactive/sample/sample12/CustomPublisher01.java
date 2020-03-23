package lines.reactive.sample.sample12;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.function.BiFunction;

public class  CustomPublisher01<T,R>  implements Publisher<R> {

    private R result;
    private Publisher<T> publisher;
    private BiFunction<R, T, R> appendBiFunction;

    public CustomPublisher01(Publisher<T> pub, R init, BiFunction<R, T, R> appendBiFunction){
        this.result = init;
        this.publisher = pub;
        this.appendBiFunction = appendBiFunction;
    }

    @Override
    public void subscribe(Subscriber<? super R> subscriber) {
        this.publisher.subscribe(new CustomSubscriber<T,R>(subscriber) {

            @Override
            public void onNext(T t) {
                result = appendBiFunction.apply(result, t);
            }

            @Override
            public void onComplete() {
                subscriber.onNext(result);
                subscriber.onComplete();
            }
        });
    }
}
