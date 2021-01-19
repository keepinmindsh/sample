package com.lines.serial;

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
            String value = "20h";
             this.outputStream.write(value.getBytes());

        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
