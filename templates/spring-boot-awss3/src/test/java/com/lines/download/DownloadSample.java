package com.lines.download;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class DownloadSample {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/download?fileName=GAIAT_20200914_20004765_1.jpg");
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream("C:\\Users\\Dream\\Downloads\\GAIAT_20200914_20004765_1.jpg");

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
}
