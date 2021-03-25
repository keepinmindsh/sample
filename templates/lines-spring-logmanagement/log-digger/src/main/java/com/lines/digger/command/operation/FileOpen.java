package com.lines.digger.command.operation;

import com.lines.lib.operation.Operate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class FileOpen implements Operate {

    private final ServerRequest serverRequest;

    @Override
    public Object operate() {

        final Mono<Object> mapper;

        final Map result = new HashMap();

        result.put("number", 1234);
        result.put("text", "webFlux");
        result.put("path", serverRequest.queryParam("path").orElse("testPath"));

        mapper = Mono.just(result);

        return mapper;
    }
}
