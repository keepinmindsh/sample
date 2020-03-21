package sample.Reactive.callrestapi.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.function.Function;

public class RequestPublisher implements Publisher<HashMap<String, Object>> {

    private final BlockingQueue<HashMap<String, Object>> queueItem;

    public RequestPublisher(Function<String, BlockingQueue<HashMap<String, Object>>> functionExecute, String key){
        this.queueItem = functionExecute.apply(key);
    }

    @Override
    public void subscribe(Subscriber<? super HashMap<String, Object>> subscriber) {
        subscriber.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                try {

                    while (!queueItem.isEmpty()){
                        subscriber.onNext(queueItem.poll());
                    }

                    subscriber.onComplete();

                }catch (Exception e) {
                    subscriber.onError(e.getCause());
                }
            }

            @Override
            public void cancel() {

            }
        });
    }
}
