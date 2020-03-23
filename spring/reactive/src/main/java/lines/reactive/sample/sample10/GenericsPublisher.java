package lines.reactive.sample.sample10;

import lines.reactive.sample.sample10.command.Command;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class GenericsPublisher<T extends Command> implements Publisher<T> {

    @Override
    public void subscribe(Subscriber<? super T> subscriber) {

    }
}
