package com.lines.api.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api1")
public class APIController {

    @GetMapping("/call")
    public Mono<String> getAPI1Service(ServerHttpRequest request, ServerHttpResponse response){
        System.out.println("API1 Service");
        HttpHeaders headers = request.getHeaders();

        headers.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });

        Mono<String> data = Mono.just("Hello from Reactive API1");

        return data;
    }
}
