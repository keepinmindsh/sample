package com.lines.digger.messages;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v1")
public class Log {

    @GetMapping("/logs")
    public Object getLogs(){

        Publisher<String> PBS = subscriber -> {
            Subscription subscription = new Subscription() {
                @Override
                public void request(long n) {

                    subscriber.onNext("abcd");

                    subscriber.onComplete();
                }
                @Override
                public void cancel() {

                }
            };

            subscriber.onSubscribe(subscription);
        };



        return Flux.from(PBS)
                .subscribe();
    }
}
