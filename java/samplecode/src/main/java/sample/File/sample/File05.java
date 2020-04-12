package sample.File.sample;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class File05 {

    public static void main(String[] args) {

        File file = new File("./hitsNew.log");

        if(file.delete()){
            log.info("File Deleted");
        }else{
            log.info("File not deleted");
        }
    }
}
