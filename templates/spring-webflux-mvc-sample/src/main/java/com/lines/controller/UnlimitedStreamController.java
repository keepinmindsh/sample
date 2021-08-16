package com.lines.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class UnlimitedStreamController {

    // TODO - curl -i localhost:8080/stream -H 'Accept: application/stream+json' : 호출 동작 안함.
    // TODO - curl -i localhost:8080/stream -H 'Accept: text/event-stream' : 호출 동작 안함.

    @GetMapping(value= "/stream")
    //@GetMapping(value= "/stream", produces = MediaType.TEXT_PLAIN_VALUE)
    Flux<Map<String, Integer>> stream() {
        Stream<Integer> stream =
                Stream.iterate(0, i -> i + 1); // Java8의 무한Stream
        return Flux
                .interval(Duration.ofMillis(1000))
                .fromStream(stream.limit(10))
                .map(i -> Collections.singletonMap("value", i));
    }
}
