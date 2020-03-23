package lines.reactive.sample;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Stack;

public class Sample02_reactiveStreams {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }

        Publisher publisher = subscriber -> {
            subscriber.onSubscribe(new Subscription() {
                @Override
                public void request(long n) {
                    System.out.println(n);

                    if(n < 0){
                        subscriber.onError(new Exception("에러가 발생하였다."));
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
                System.out.println(" On Next" + o);

                subscription.request(1);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("On Complete");
            }
        };

        publisher.subscribe(subscriber);
    }

}
