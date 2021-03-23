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
    public Mono<ServerResponse> post(ServerRequest serverRequest, OperationCode operationCode){
        Command command = new LogCommand(operationCode);

        command.execute();

        return ServerResponse.ok().body(BodyInserters.fromProducer(command.result(), LogRSVO.class));
    }
}
