package com.example.springcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayApplication.class, args);
    }

    @Bean
    RouteLocator gateway ( RouteLocatorBuilder rlb ) {
        return rlb
                .routes()
                .route( routeSpec ->
                        routeSpec.path("/hello").and().host("*.spring.io")
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
