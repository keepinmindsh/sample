package sample.File.sample;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Slf4j
public class File09 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./file.txt");

        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(100);

        Charset charset = Charset.defaultCharset();
        String data = "";

        int byteCount;

        while (true) {
            byteCount = fileChannel.read(buffer);

            if (byteCount == -1)
                break;

            buffer.flip();
            data += charset.decode(buffer).toString();
            buffer.clear();
        }

        fileChannel.close();

        log.info("data : " + data);


    }
}
