package com.example.springcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


public class SpringCloudGatewayApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayApplication2.class, args);
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
