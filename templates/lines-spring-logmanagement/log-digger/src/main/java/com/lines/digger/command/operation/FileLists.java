package com.lines.digger.command.operation;

import com.lines.digger.model.LogFileVO;
import com.lines.lib.operation.Operate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Slf4j
public class FileLists implements Operate {

    private final ServerRequest serverRequest;

    @Override
    public Object operate() throws Exception {
        String startPath = serverRequest.queryParam("path").orElse("/");

        try (Stream<Path> stream = Files.walk(Paths.get(startPath), 1)) {
            List<LogFileVO> logTreeVOList = stream
                    .filter(file -> file.toFile().isFile())
                    .map((path) -> {
                        String creationTime = "";
                        try {
                            long timeMillis = Files.readAttributes(path, BasicFileAttributes.class).creationTime().toMillis();

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

                            Date date = new Date(timeMillis);
                            creationTime = sdf.format(date);
                        } catch (Exception exception) {
                            log.error("File BasicFileAttributes error");
                            log.error(exception.getMessage());
                        }

                        return LogFileVO.builder()
                            .filePath(startPath + path.getFileName().toString())
                            .fileName(path.getFileName().toString())
                            .createdDate(creationTime)
                            .build();
                    })
                    .collect(Collectors.toList());
            log.info(String.format("logFile : %s", logTreeVOList.toString()));
            return logTreeVOList;
        }catch (Exception exception){
            return new ArrayList<LogFileVO>();
        }
    }
}
