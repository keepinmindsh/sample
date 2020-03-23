package lines.reactive.sample.sample09.reactive;


import lines.reactive.sample.sample09.command.handler.CommandHandler;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class CustomPublisher implements Publisher<CommandHandler> {

    private final CommandHandler commandHandler;

    public CustomPublisher(CommandHandler commandHandler){
        this.commandHandler = commandHandler;
    }

    @Override
    public void subscribe(Subscriber<? super CommandHandler> subscriber) {
        subscriber.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                subscriber.onNext(commandHandler);

                subscriber.onComplete();
            }

            @Override
            public void cancel() {

            }
        });
    }
}
