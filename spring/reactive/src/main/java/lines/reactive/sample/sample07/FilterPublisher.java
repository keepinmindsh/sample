package lines.reactive.sample.sample07;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class FilterPublisher implements Publisher<Command> {

    private Publisher<Command> publisher;

    public FilterPublisher(Publisher<Command> publisher){
        this.publisher = publisher;
    }

    @Override
    public void subscribe(Subscriber<? super Command> subscriber) {
        this.publisher.subscribe(new Subscriber<Command>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscriber.onSubscribe(subscription);
            }

            @Override
            public void onNext(Command command) {
                if(!command.isMinus()){
                    subscriber.onNext(command);
                }
            }

            @Override
            public void onError(Throwable t) {
                subscriber.onError(t);
            }

            @Override
            public void onComplete() {
                subscriber.onComplete();
            }
        });
    }
}
