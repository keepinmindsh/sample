package lines.reactive.sample;

import lines.reactive.sample.sample11.CustomSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample11_reactiveStreams11 {

    public static void main(String[] args) {
        Publisher<Integer> pub = settingPublisher(Stream.iterate(1, a -> a + 1).limit(10).collect(Collectors.toList()));

        Publisher<StringBuilder> reducePublisher= reducePublisher(pub, new StringBuilder(), (a, b) -> a.append(b + ","));

        reducePublisher.subscribe(logSubscriber());
    }

    private static Publisher<Integer> settingPublisher(List<Integer> iter) {
        return new Publisher<Integer>() {

            Iterable<Integer> iteratorable = iter;

            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        try {
                            iteratorable.forEach(subscriber::onNext);
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
        };
    }

    private static <T,R> Publisher<R> reducePublisher(Publisher<T> pub, R init, BiFunction<R, T, R> appendBiFunction) {
        return new Publisher<R>() {
            @Override
            public void subscribe(Subscriber<? super R> subscriber) {

                pub.subscribe(new CustomSubscriber<T,R>(subscriber){

                    R result = init;

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
        };
    }

    private static <T> Subscriber<T> logSubscriber() {
        return new Subscriber<T>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("onSubscribe :");
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(T t) {  // 정상적인 데이터
                System.out.println("OnNext : " + t);
            }

            @Override
            public void onError(Throwable throwable) { // 에러
                System.out.println("OnError : {}" + throwable.getMessage());
            }

            @Override
            public void onComplete() { // 완료 시그널 처리
                System.out.println("OnComplete : {}" );
            }
        };
    }

}
