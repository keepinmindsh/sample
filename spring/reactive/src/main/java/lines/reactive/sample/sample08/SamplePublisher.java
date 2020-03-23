package lines.reactive.sample.sample08;

import lines.reactive.sample.sample08.handler.CommandHandler;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

public class SamplePublisher implements Publisher<CommandHandler> {

    private final List<CommandHandler> commandHandlerList;

    public SamplePublisher(List<CommandHandler> commandHandlerList){
        this.commandHandlerList = commandHandlerList;
    }

    @Override
    public void subscribe(Subscriber<? super CommandHandler> subscriber) {
        subscriber.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                commandHandlerList.forEach(subscriber::onNext);

                // 데이터 전송 처리 완료
                subscriber.onComplete();
            }

            @Override
            public void cancel() {

            }
        });
    }
}
