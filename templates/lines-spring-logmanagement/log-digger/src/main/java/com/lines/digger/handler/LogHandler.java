package com.lines.digger.handler;

import com.lines.digger.code.OperationCode;
import com.lines.digger.command.LogCommand;
import com.lines.lib.command.Command;
import com.lines.model.LogRSVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class LogHandler {
    public Mono<ServerResponse> post(ServerRequest serverRequest, OperationCode operationCode){
        Command command = new LogCommand(operationCode);

        command.execute();

        return ServerResponse.ok().body(command.result(), LogRSVO.class);
    }
}
