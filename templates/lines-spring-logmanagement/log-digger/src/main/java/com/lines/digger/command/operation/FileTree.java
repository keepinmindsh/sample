package com.lines.digger.command.operation;

import com.lines.lib.operation.Operate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
public class FileTree implements Operate {

    private final ServerRequest serverRequest;

    @Override
    public Object operate() throws Exception {
        try (Stream<Path> stream = Files.walk(Paths.get(serverRequest.queryParam("path").orElse("/")), 1)) {
            return stream
                    .filter(file -> Files.isDirectory(file))
                    .map((path) -> {

                        String filePath = path.getFileName().toString();

                        log.info("filePath : {} ", filePath);

                        return path;

                    })
                    .map(Path::toString)
                    .collect(Collectors.toList());
        }
    }
}
