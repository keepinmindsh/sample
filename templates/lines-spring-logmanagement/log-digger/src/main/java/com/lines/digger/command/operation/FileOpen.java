package com.lines.digger.command.operation;

import com.lines.lib.operation.Operate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.zip.GZIPInputStream;

@RequiredArgsConstructor
@Slf4j
public class FileOpen implements Operate {

    private final ServerRequest serverRequest;

    @Override
    public Object operate() {
        final String filePath = serverRequest.queryParam("filePath").orElse("");
        String content = "";

        if(filePath.indexOf(".gz") > -1){
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        new GZIPInputStream(new FileInputStream(filePath))));

                String lines = "";
                while ((lines = in.readLine()) != null)
                    content += lines;

            } catch (Exception exception) {
                log.error(exception.getMessage());
                content = "File Open Error - GZ " + exception.getMessage();
            }
        }else{
            Path path = Paths.get(filePath);

            if (Files.exists(path)) {
                try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate((int) Files.size(path));

                    channel.read(byteBuffer);

                    byteBuffer.flip();

                    content = Charset.forName("UTF-8").decode(byteBuffer).toString();

                    log.info("file content : {}", content);

                } catch (Exception exception) {
                    log.error(exception.getMessage());
                    content = "File Open Error - " + exception.getMessage();
                }
            }
        }

        content = content.replaceAll("(\r\n|\n)", "<br/>");
        content = content.replaceAll("\\s", "&nbsp;");

        return content;
    }
}
