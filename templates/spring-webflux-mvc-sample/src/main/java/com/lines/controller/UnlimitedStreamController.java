package com.lines.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class UnlimitedStreamController {

    //@GetMapping(value= "/stream")
    @GetMapping(value= "/stream", produces = MediaType.TEXT_PLAIN_VALUE)
    Flux<Map<String, Integer>> stream() {
        Stream<Integer> stream = Stream.iterate(0, i -> i + 1); // Java8의 무한Stream
        return Flux.fromStream(stream.limit(10))
                .map(i -> Collections.singletonMap("value", i));
    }
}
