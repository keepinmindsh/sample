package com.lines.digger.handler;

import com.lines.digger.code.OperationCode;
import com.lines.digger.command.LogCommand;
import com.lines.lib.command.Command;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class LogHandler {
    public Mono<ServerResponse> post(ServerRequest serverRequest, OperationCode operationCode) throws Exception {
        Command command = new LogCommand(operationCode, serverRequest);

        command.execute();

        return ServerResponse.ok().bodyValue(command.result());
    }
}
