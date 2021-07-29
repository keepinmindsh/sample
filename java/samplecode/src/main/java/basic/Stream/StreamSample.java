package basic.Stream;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class StreamSample {
    public static void main(String[] args) throws IOException {

        // Input Stream - Read
        inputStream_readSample();

        // Input Stream - Read Case 2
        // TODO 코드에 대한 이해가 필요합니다~! 추후 재검토
        inputStream_readSample1();
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

    private static void inputStream_readSample1() throws IOException {
        InputStream inputStream = null;
        byte[] buffer = new byte[8192];
        char chracter;

        try {
            // new input stream created
            inputStream = new FileInputStream("D:\\GIT\\sample\\sample\\java\\samplecode\\sample_data.txt");

            log.info("Characters printed:");

            // read stream data into buffer
            inputStream.read(buffer, 2, 3);

            // for each byte in the buffer
            for(byte byteCode : buffer) {

                // convert byte to character
                if(byteCode == 0)
                    // if b is empty
                    chracter = '-';
                else
                    // if b is read
                    chracter = (char)byteCode ;

                log.info("Converted : {}", chracter);
            }

        } catch(Exception exception) {
            // if any I/O error occurs
            exception.printStackTrace();

            log.error(exception.getMessage());
        } finally {
            // releases system resources associated with this stream
            if(inputStream != null)
                inputStream.close();
        }
    }
}
