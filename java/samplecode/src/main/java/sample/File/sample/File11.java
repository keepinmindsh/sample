package sample.File.sample;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
public class File11 {
    public static void main(String[] args) throws IOException {
        Path from = Paths.get("./file.txt");
        Path to = Paths.get("./file2.txt");

        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        log.info("File 생성이 완료되었습니다, ");
    }
}
