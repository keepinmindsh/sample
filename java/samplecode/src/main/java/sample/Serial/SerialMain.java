package sample.Serial;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Slf4j
public class SerialMain {

    static {
        try{
//            InputStream in = SerialMain.class.getResourceAsStream("/Users/dream/git/sample/java/samplecode/src/main/resources/rxtxSerial.dll");
//
//            byte[] buffer = new byte[1024];
//            int read = -1;
//
//            File temp = File.createTempFile("/Users/dream/git/sample/java/samplecode/src/main/resources/rxtxSerial.dll", "");
//
//            FileOutputStream fos = new FileOutputStream(temp);
//
//            while((read = in.read(buffer)) != -1) {
//                fos.write(buffer, 0, read);
//            }
//            fos.close();
//            in.close();
//
//            log.info(temp.getAbsolutePath());

            System.setProperty("java.library.path", "/Users/dream/git/sample/java/samplecode/src/main/resources/rxtxSerial.dll");

            //System.load("/Users/dream/git/sample/java/samplecode/src/main/resources/rxtxSerial.dll");
            System.loadLibrary("rxtxSerial");
        } catch (Exception exception){
            log.error(exception.getMessage());
        }
    }

    public static void main(String[] args) {
        try{
            (new Serial()).connect("COM6");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
