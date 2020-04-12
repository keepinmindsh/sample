package sample.File.sample;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Slf4j
public class File10 {
    public static void main(String[] args) throws IOException {
        Path from = Paths.get("./file.txt");
        Path to = Paths.get("./file_copy.txt");

        if(!Files.exists(to)){
            Files.createFile(to);
        }

        FileChannel fileChannel_from = FileChannel.open(from, StandardOpenOption.READ);
        FileChannel fileChannel_to = FileChannel.open(to, StandardOpenOption.WRITE);

        ByteBuffer buffer = ByteBuffer.allocateDirect(100);

        int byteCount = 0;

        while (true) {
            buffer.clear();
            byteCount = fileChannel_from.read(buffer);

            if (byteCount == -1)
                break;

            buffer.flip();
            fileChannel_to.write(buffer);
        }

        fileChannel_from.close();
        fileChannel_to.close();

        log.info("파일 복사 성공!!");
    }
}
