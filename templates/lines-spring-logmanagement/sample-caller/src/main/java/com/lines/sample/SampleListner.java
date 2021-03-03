package com.lines.sample;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SampleListner {

    private static ScheduledExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadScheduledExecutor();



    @PostConstruct
    public void init(){
        System.out.println("초기화 메소드!!");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void EventListenerExecute(){
        EXECUTOR_SERVICE.scheduleAtFixedRate(() -> {

            List<String> dataList =  Stream.iterate(0 , i ->  i + 1).limit(1000).map(intValue -> { return "Value" + intValue; } ).collect(Collectors.toList());

            dataList.forEach(value -> {
                WebClient webClient = WebClient.create("http://localhost:9090");

                Mono<String> stringMono = webClient.post()
                        .uri("/v1/log")

                        .body(Mono.just(value), String.class)
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToMono(String.class);

            });

        }, 0, 10, TimeUnit.SECONDS);
    }
}

