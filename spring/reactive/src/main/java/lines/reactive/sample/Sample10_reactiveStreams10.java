package lines.reactive.sample;


import lines.reactive.sample.sample10.GenericsPublisher;
import lines.reactive.sample.sample10.GenericsSubscriber;
import lines.reactive.sample.sample10.command.AttackCommand;
import lines.reactive.sample.sample10.command.Command;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Sample10_reactiveStreams10 {

    public static void main(String[] args) {

        Command command = new AttackCommand();

        Publisher<Command> publisher = new GenericsPublisher<Command>() {
            @Override
            public void subscribe(Subscriber<? super Command> subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        subscriber.onNext(command);
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        Subscriber<Command> subscriber = new GenericsSubscriber<Command>(){
            @Override
            public void onSubscribe(Subscription subscription) {
                super.onSubscribe(subscription);
            }

            @Override
            public void onNext(Command command) {
                command.execute();
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

        publisher.subscribe(subscriber);
    }
}
