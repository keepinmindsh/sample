package com.lines.digger.router;

import com.lines.digger.handler.LogHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

@Configuration
public class LogRouter {


    //TODO - https://d2.naver.com/helloworld/6080222 참고해서 Router 함수 적용하기
    @Bean
    public RouterFunction<ServerResponse> routes(LogHandler logHandler){
        return RouterFunctions.route(RequestPredicates.POST("/demo").and(contentType(APPLICATION_JSON)), logHandler::post);
    }


//    @GetMapping("/logs")
//    public Object getLogs(){
//
//        Publisher<String> PBS = subscriber -> {
//            Subscription subscription = new Subscription() {
//                @Override
//                public void request(long n) {
//
//                    subscriber.onNext("abcd");
//
//                    subscriber.onComplete();
//                }
//                @Override
//                public void cancel() {
//
//                }
//            };
//
//            subscriber.onSubscribe(subscription);
//        };
//
//
//
//        return Flux.from(PBS)
//                .subscribe();
//    }
}
