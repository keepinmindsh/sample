package com.lines.serial;

import java.io.IOException;
import java.io.InputStream;

public class SerialReader implements Runnable{

    InputStream inputStream;

    public SerialReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];

        int len = -1;

        try {
            while((len = this.inputStream.read(buffer)) > -1){
                String value = new String(buffer, 0, len);
                if(value.indexOf("^U") > -1){
                    break;
                }
            }
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
