package com.lines.digger.command.operation;

import com.lines.lib.operation.Operate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class FileTree implements Operate {

    private final ServerRequest serverRequest;

    @Override
    public Object operate() throws Exception {
        try (Stream<Path> stream = Files.walk(Paths.get(serverRequest.queryParam("path").orElse("/")), 1)) {
            return stream
                    .filter(file -> Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        }
    }
}
