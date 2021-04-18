package com.lines.digger.command.operation;

import com.lines.digger.model.LogTreeVO;
import com.lines.lib.operation.Operate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
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
        String startPath = serverRequest.queryParam("path").orElse("/");

        try (Stream<Path> stream = Files.walk(Paths.get(startPath), 1)) {
            List<LogTreeVO> logTreeVOList = stream
                            .filter(file -> Files.isDirectory(file))
                            .map((path) -> LogTreeVO.builder()
                                        .hasChild(Files.exists(path))
                                        .path(startPath + path.getFileName() + File.separator)
                                        .isParent(false)
                                        .label(path.getFileName().toString())
                                        .build())
                            .collect(Collectors.toList());

            Path rootPath = Paths.get(startPath).getParent();

            logTreeVOList.remove(0);

            LogTreeVO logRootVO = LogTreeVO.builder()
                    .hasChild(Files.exists(rootPath))
                    .path(rootPath.toAbsolutePath().toString()+ File.separator)
                    .isParent(true)
                    .label("...")
                    .build();

            logTreeVOList.add(0, logRootVO);

            return logTreeVOList;
        }
    }
}
