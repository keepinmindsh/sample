package sample.File.sample;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class File01 {

    public static void main(String[] args) {
        String path = "./log.log";

        File file = new File(path);

        if(!file.exists()){
            log.info("The input file dose not exist!");
        }
    }
}
