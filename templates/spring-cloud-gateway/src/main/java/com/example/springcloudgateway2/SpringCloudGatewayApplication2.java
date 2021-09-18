package com.example.springcloudgateway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;


public class SpringCloudGatewayApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayApplication2.class, args);
    }

    // TODO - https://spring.io/blog/2018/03/16/micrometer-spring-boot-2-s-new-application-metrics-collector

    // TODO - Actuator를 통한 Metrics 확인
    // http://localhost:9999/actuator/metrics
    // http://localhost:9999/actuator/metrics/spring.cloud.gateway.requests
    // http://localhost:9999/twitter/starbuxman

    RouteLocator gateway2 ( RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("after_route", null ).build();
    }

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
