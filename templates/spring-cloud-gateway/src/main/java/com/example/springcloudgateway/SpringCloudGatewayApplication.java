package com.example.springcloudgateway;

import org.reactivestreams.Publisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.handler.AsyncPredicate;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;

@SpringBootApplication
public class SpringCloudGatewayApplication {

    // TODO - https://spring.io/blog/2018/03/16/micrometer-spring-boot-2-s-new-application-metrics-collector

    // TODO - Actuator를 통한 Metrics 확인
    // http://localhost:9999/actuator/metrics
    // http://localhost:9999/actuator/metrics/spring.cloud.gateway.requests
    // http://localhost:9999/twitter/starbuxman

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayApplication.class, args);
    }


    @Bean
    RouteLocator gateway ( RouteLocatorBuilder rlb ) {
        return rlb
                .routes()
                .route( routeSpec ->
                        routeSpec.path("/hello").and().host("*.spring.io")
//                                .and()
//                                    .asyncPredicate(new AsyncPredicate<ServerWebExchange>() {
//                                        @Override
//                                        public Publisher<Boolean> apply(ServerWebExchange serverWebExchange) {
//                                            return Mono.just(serverWebExchange.getAttribute("foo"));
//                                        }
//                                    })
                                .filters(gatewayFilterSpec ->
                                        gatewayFilterSpec.setPath("/guides"))
                                .uri("https://spring.io/")
                        )
                .route("twitter", routeSpec ->
                    routeSpec.path("/twitter/**")
                            .filters( fs -> fs.rewritePath("/twitter/(?<handle>.*)",
                                    "/${handle}"
                                    )
                            ).uri("http://twitter.com/@"))

                .build();
    }

}
