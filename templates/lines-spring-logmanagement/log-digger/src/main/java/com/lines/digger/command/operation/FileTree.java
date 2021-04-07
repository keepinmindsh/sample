package com.lines.digger.command.operation;

import com.lines.digger.model.LogTreeVO;
import com.lines.lib.operation.Operate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
                    .map((path) -> LogTreeVO.builder()
                                .children(recursiveSearchFolder(path))
                                .hasChild(Files.exists(path))
                                .label(path.getFileName().toString())
                                .build())
                    .collect(Collectors.toList());
        }
    }

    // TODO Tree 구조 추가 분석 필요 
    private List<LogTreeVO> recursiveSearchFolder(Path path){
        if(Files.exists(path)){
            try (Stream<Path> stream = Files.walk(path, 1)) {
                return stream
                        .filter(file -> Files.isDirectory(file))
                        .map((deepPath) -> {

                            log.info("log : {}", deepPath.toAbsolutePath().getFileName().toString());

                            return LogTreeVO.builder()
                                    .children(recursiveSearchFolder(deepPath))
                                    .hasChild(Files.exists(deepPath))
                                    .label(deepPath.getFileName().toString())
                                    .build();

                        })
                        .collect(Collectors.toList());
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return new ArrayList<LogTreeVO>();
            }
        }else{
            return new ArrayList<LogTreeVO>();
        }
    }
}
