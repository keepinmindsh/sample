package sample.Serial;

import java.io.IOException;
import java.io.OutputStream;

public class SerialWriter implements Runnable{

    OutputStream outputStream;

    public SerialWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            int c = 0;

            while(( c = System.in.read()) > -1){
                this.outputStream.write(c);
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
