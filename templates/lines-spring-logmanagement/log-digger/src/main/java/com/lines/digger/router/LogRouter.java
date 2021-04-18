package com.lines.digger.router;

import com.lines.digger.code.OperationCode;
import com.lines.digger.handler.FirstHandler;
import com.lines.digger.handler.LogHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Configuration
@EnableWebFlux
@RequiredArgsConstructor
public class LogRouter {

    private final LogHandler logHandler;
    private final FirstHandler firstHandler;

    //TODO - https://d2.naver.com/helloworld/6080222 참고해서 Router 함수 적용하기
    //TODO - https://alwayspr.tistory.com/44
    //TODO - https://lts0606.tistory.com/301
    @Bean
    public RouterFunction<ServerResponse> routes(LogHandler logHandler){
        return RouterFunctions
                .route(RequestPredicates.GET("/file/analyze").and(RequestPredicates.accept(APPLICATION_JSON)),
                        serverRequest -> {
                            try {
                                return logHandler.post(serverRequest, OperationCode.FILE_ANALYZE);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                                return null;
                            }
                        })
                .andRoute(RequestPredicates.GET("/file/lists").and(RequestPredicates.accept(APPLICATION_JSON)),
                        serverRequest -> {
                            try {
                                return logHandler.post(serverRequest, OperationCode.FILE_LIST);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                                return null;
                            }
                        }
                        )
                .andRoute(RequestPredicates.GET("/file/open").and(RequestPredicates.accept(APPLICATION_JSON)),
                        serverRequest -> {
                            try {
                                return logHandler.post(serverRequest, OperationCode.FILE_OPEN);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                                return null;
                            }
                        })
                .andRoute(RequestPredicates.GET("/file/tree").and(RequestPredicates.accept(APPLICATION_JSON)),
                        serverRequest -> {
                            try {
                                return logHandler.post(serverRequest, OperationCode.FILE_TREE);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                                return null;
                            }
                        });
    }

    @Bean
    public RouterFunction<ServerResponse> route(FirstHandler firstHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), firstHandler::hello);
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
