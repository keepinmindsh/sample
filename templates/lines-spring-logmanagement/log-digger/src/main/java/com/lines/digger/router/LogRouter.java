package com.lines.digger.router;

import com.lines.digger.code.OperationCode;
import com.lines.digger.handler.LogHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

@Configuration
@EnableWebFlux
public class LogRouter {


    //TODO - https://d2.naver.com/helloworld/6080222 참고해서 Router 함수 적용하기
    @Bean
    public RouterFunction<ServerResponse> routes(LogHandler logHandler){
        return RouterFunctions
                .route(RequestPredicates.POST("/file/analyze").and(contentType(APPLICATION_JSON)),
                        serverRequest -> logHandler.post(serverRequest, OperationCode.FILE_ANALYZE))
                .andRoute(RequestPredicates.POST("/file/open").and(contentType(APPLICATION_JSON)),
                        serverRequest -> logHandler.post(serverRequest, OperationCode.FILE_OPEN))
                .andRoute(RequestPredicates.POST("/file/tree").and(contentType(APPLICATION_JSON)),
                        serverRequest -> logHandler.post(serverRequest, OperationCode.FILE_TREE))
                .andRoute(RequestPredicates.POST("/reservation/get").and(contentType(APPLICATION_JSON)),
                        serverRequest -> logHandler.post(serverRequest, OperationCode.RESERVATION_GET))
                .andRoute(RequestPredicates.POST("/reservation/keep").and(contentType(APPLICATION_JSON)),
                        serverRequest -> logHandler.post(serverRequest, OperationCode.RESERVATION_KEEP));
    }

    // TODO - https://github.com/eugenp/tutorials/blob/master/spring-5-reactive-security/src/main/java/com/baeldung/reactive/functional/EmployeeFunctionalConfig.java 참고 코드 작성
    /*

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.csrf()
                .disable()
                .authorizeExchange()
                .anyExchange()
                .permitAll();
        return http.build();
    }

    */


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
