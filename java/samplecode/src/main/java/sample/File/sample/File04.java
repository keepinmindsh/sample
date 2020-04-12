package sample.File.sample;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class File04 {
    public static void main(String[] args) throws IOException {
        File file = new File("./hits.log");

        if(file.createNewFile()){
            log.info("File Created");
        }else{
            log.info("File Not Created");
        }

        if(file.renameTo(new File("./hitsNew.log"))){
            log.info("File renamed");
        }else {
            log.info("File not moved");
        }
    }
}
