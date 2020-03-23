package lines.reactive.sample;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Stack;

public class Sample01_loopCount {
    public static void main(String[] args) {

        Publisher publisher = new Publisher() {

            Stack<Integer> stack;

            @Override
            public void subscribe(Subscriber subscriber) {

                stack = new Stack<>();

                for (int i = 0; i < 10; i++) {
                    stack.push(i);
                }

                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        System.out.println("request " + n);

                        if(n < 0){
                            subscriber.onError(new Exception(" 0 이상의 숫자를 넣어야 합니다. "));
                        }

                        for (int i = 0; i < n; i++) {
                            if(stack.empty()){
                                subscriber.onComplete();
                            }

                            subscriber.onNext(stack.pop());
                        }
                    }

                    @Override
                    public void cancel() {

                    }
                });

            }
        };

        Subscriber subscriber = new Subscriber() {

            Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;

                subscription.request(1);
            }

            @Override
            public void onNext(Object o) {
                System.out.println(" onNext - " + o);

                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(" onError - " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println(" onComplete");
            }
        };

        publisher.subscribe(subscriber);

    }
}
