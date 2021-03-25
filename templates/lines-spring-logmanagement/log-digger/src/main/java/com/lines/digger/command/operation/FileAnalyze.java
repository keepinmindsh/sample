package com.lines.digger.command.operation;

import com.lines.lib.operation.Operate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.server.ServerRequest;

@RequiredArgsConstructor
public class FileAnalyze implements Operate {

    private final ServerRequest serverRequest;

    @Override
    public Object operate() {
        return null;
    }
}
