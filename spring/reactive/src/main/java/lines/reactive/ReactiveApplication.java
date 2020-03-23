package lines.reactive;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 코어에 담겨 있는 것은 무엇인가를 파악하는 것이 중요함

 Reactive Web

 Reactive Programming


*/


@SpringBootApplication
public class ReactiveApplication {

    @RestController
    public static class Controller {

        @RequestMapping("/hello")
        public Publisher<String> hello(String name){
            return new Publisher<String>() {
                @Override
                public void subscribe(Subscriber<? super String> subscriber) {
                    subscriber.onSubscribe(new Subscription() {
                        @Override
                        public void request(long n) {
                            subscriber.onNext("Hello" + name);
                            subscriber.onComplete();
                        }

                        @Override
                        public void cancel() {

                        }
                    });
                }
            };
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApplication.class, args);
    }

}
