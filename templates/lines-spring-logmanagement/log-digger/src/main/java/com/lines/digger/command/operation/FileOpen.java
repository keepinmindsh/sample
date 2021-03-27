package com.lines.digger.command.operation;

import com.lines.lib.operation.Operate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RequiredArgsConstructor
@Slf4j
public class FileOpen implements Operate {

    private final ServerRequest serverRequest;

    @Override
    public Object operate() {
        final String filePath = serverRequest.queryParam("filePath").orElse("");

        Path path = Paths.get(filePath);

        String content = "";

        if (Files.exists(path)) {
            try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
                ByteBuffer byteBuffer = ByteBuffer.allocate((int) Files.size(path));

                channel.read(byteBuffer);

                byteBuffer.flip();

                content = Charset.defaultCharset().decode(byteBuffer).toString();

                log.info("file content : {}", content);

            } catch (Exception exception) {
                log.info(exception.getMessage());
                exception.printStackTrace();
            }
        }

        return content;
    }
}
