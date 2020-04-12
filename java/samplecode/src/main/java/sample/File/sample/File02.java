package sample.File.sample;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class File02 {

    public static void main(String[] args) throws IOException {
        File file = new File("./log.log");

        if(file.createNewFile()){
            log.info("File Created.");
        }else{
            log.info("File could not be created.");
        }
    }
}
