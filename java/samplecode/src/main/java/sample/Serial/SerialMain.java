package sample.Serial;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;

@Slf4j
public class SerialMain {

    static {
        try{

        } catch (Exception exception){
            log.error(exception.getMessage());
        }
    }

    private static void loadLib(String path, String name) {
        name = System.mapLibraryName(name); // extends name with .dll, .so or .dylib
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(path + name);

//            File fileOut = new File("D://GIT/sample/sample/java/samplecode/src/main/resources/temp/rxtxSerial.dll");
            File fileOut = new File(path + name);
            outputStream = new FileOutputStream(fileOut);
            IOUtils.copy(inputStream, outputStream);
            System.load(fileOut.toString());//loading goes here
        } catch (Exception e) {
            //handle
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    //log
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    //log
                }
            }
        }
    }

    public static void main(String[] args) {
        try{
            (new Serial()).connect("COM1");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
