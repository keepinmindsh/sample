package basic.Stream;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.InputStream;

@Slf4j
public class StreamSample {
    public static void main(String[] args) {

        // Input Stream - Read
        inputStream_readSample();
    }

    private static void inputStream_readSample() {
        try(InputStream inputStream = new FileInputStream("D:\\GIT\\sample\\sample\\java\\samplecode\\sample_data.txt");){

            int readByte;

            while((readByte = inputStream.read()) != -1){
                log.info("{}", readByte);
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
