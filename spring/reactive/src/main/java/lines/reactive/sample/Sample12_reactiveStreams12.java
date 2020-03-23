package lines.reactive.sample;

import lines.reactive.sample.sample12.CustomPublisher01;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample12_reactiveStreams12 {
    public static void main(String[] args) {
        List<Integer> integerList = Stream.iterate(1, a -> a + 1).limit(100).collect(Collectors.toList());

        Publisher<Integer> publisher = new Publisher<Integer>() {

            Iterable<Integer> integerIterable = integerList;

            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        integerIterable.forEach(subscriber::onNext);
                        subscriber.onComplete();
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        Publisher<StringBuilder> publisherStringBuilder = new CustomPublisher01<Integer, StringBuilder>(publisher, new StringBuilder(), (a , b) -> a.append(b + ","));

        publisherStringBuilder.subscribe(new Subscriber<StringBuilder>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(StringBuilder stringBuilder) {
                System.out.println("OnNext : " + stringBuilder);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            };

        });

    }
}
