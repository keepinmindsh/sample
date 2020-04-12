package sample.File.sample;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class File07 {
    public static void main(String[] args) {
        String pathSetting = "/log11.txt";

        Path path = Paths.get(pathSetting);

        try{
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            for(Path pathFile : directoryStream) {
                if(Files.isDirectory(path)) {
                    System.out.println("[[디렉토리]] " + pathFile.getFileName());
                } else {
                    System.out.println("[[파일]] " + pathFile.getFileName() + " (크기:" + Files.size(pathFile) + ")");
                }
            }

        }catch (Exception ex){
            log.error("Error :" + ex.getMessage());
        }

    }
}
