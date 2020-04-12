package sample.File.sample;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class File03 {
    public static void main(String[] args) {
        File file = new File("/Users/dream/GIT/sample/spring/javafx/src/main/java/");
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File fileItem :
                    files) {

                log.info(fileItem.getName());

                if(fileItem.isFile() && !fileItem.isHidden()){
                    log.info(fileItem.getName());
                }
            }
        }
    }
}
