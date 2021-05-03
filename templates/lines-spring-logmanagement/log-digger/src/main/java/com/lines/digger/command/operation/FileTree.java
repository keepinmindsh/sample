package com.lines.digger.command.operation;

import com.lines.digger.model.LogTreeVO;
import com.lines.lib.operation.Operate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
public class FileTree implements Operate {

    private final ServerRequest serverRequest;

    @Override
    public Object operate() throws Exception {
        String startPath = serverRequest.queryParam("path").orElse("/");
        String fixedPath = startPath.endsWith("//") ? startPath.replace("//", "/") : startPath;

        System.out.println(String.format("Path : %s", fixedPath));

        try (Stream<Path> stream = Files.walk(Paths.get(fixedPath).toAbsolutePath(), 1)) {
            List<LogTreeVO> logTreeVOList = stream
            		 .filter(file -> Files.isDirectory(file))
                     .map((path) -> LogTreeVO.builder()
                                 .hasChild(Files.exists(path))
                                 .childCount(new File(path.toString()).list().length)
                                 .path(fixedPath + path.getFileName() + "/")
                                 .isParent(new File(path.toString()).list().length != 0 ? true : false)
                                 .label(path.getFileName().toString())
                                 .build())
                     .collect(Collectors.toList());

            Path rootPath = Paths.get(startPath).getParent();

            logTreeVOList.remove(0);

            LogTreeVO logRootVO = LogTreeVO.builder()
                    .hasChild(Files.exists(rootPath))
                    .path(rootPath.toAbsolutePath().toString()+ "/")
                    .isParent(true) 
                    .label("...")
                    .build();

            logTreeVOList.add(0, logRootVO);

            return logTreeVOList;
        }
    }
}
