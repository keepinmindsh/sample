package com.lines.digger.handler;

import com.lines.digger.code.OperationCode;
import com.lines.digger.command.LogCommand;
import com.lines.lib.command.Command;
import com.lines.model.LogRSVO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Component
public class LogHandler {

    private HashMap<Object, Object> result = new HashMap<>();
    private Mono<HashMap<Object, Object>> mapper = Mono.just(result);

    public Mono<ServerResponse> post(ServerRequest serverRequest, OperationCode operationCode){

        result.put("number", 1234);
        result.put("text", "webFlux");

        // TODO 파일을 가져오는 프로세스 추가 필요 
        mapper.subscribe( (arg)->{
            Command command = new LogCommand(operationCode, result);

            command.execute();
        });

        return ServerResponse.ok().body(BodyInserters.fromProducer(mapper, LogRSVO.class));
    }
}
