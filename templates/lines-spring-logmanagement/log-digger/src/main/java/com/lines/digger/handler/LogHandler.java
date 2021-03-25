package com.lines.digger.handler;

import com.lines.digger.code.OperationCode;
import com.lines.digger.command.LogCommand;
import com.lines.lib.command.Command;
import com.lines.model.LogRSVO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Component
public class LogHandler {

    private HashMap<Object, Object> result = new HashMap<>();

    public Mono<ServerResponse> post(ServerRequest serverRequest, OperationCode operationCode){

        Command command = new LogCommand(operationCode, serverRequest, result);

        command.execute();

        // TODO 응답이 정상적으로 반환되지 않음.

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromProducer(command.result(), HashMap.class));
    }
}
