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
                System.out.print(value + ">");


                if(value.indexOf("^U") > -1){
                    break;
                }

                if(value.indexOf("53") > -1){
                    break;
                }

                if(value.indexOf("\u0015") > -1){
                    System.out.print(byteArrayToHex(buffer));
                    break;
                }


            }
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public static String byteArrayToHex(byte[] byteArray) {
        if (byteArray == null || byteArray.length == 0) {
            return null;
        }
        StringBuilder stringBuffer = new StringBuilder(byteArray.length * 2);
        String hexNumber;
        for (byte aBa : byteArray) {
            hexNumber = "0" + Integer.toHexString(0xff & aBa);

            stringBuffer.append(hexNumber.substring(hexNumber.length() - 2));
            //stringBuffer.append(hexNumber);
        }
        return stringBuffer.toString();
    }
}
