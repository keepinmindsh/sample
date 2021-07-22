package com.lines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    @Bean
    RouteLocator gateway(RouteLocatorBuilder routeLocatorBuilder){

        // TODO - https://www.youtube.com/watch?v=puIJ1Mn9_LE&t=784s

        return routeLocatorBuilder
                .routes()
                .route(routeSpec ->
                        routeSpec.path("/hello")
                                .filters(gatewayFilterSpec ->
                                    gatewayFilterSpec.setPath("/guides")
                                )
                        .uri("https://spring.io/")
                )
                .build();
    }
}
