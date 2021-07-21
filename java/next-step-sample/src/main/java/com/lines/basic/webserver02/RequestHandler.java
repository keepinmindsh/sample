package com.lines.basic.webserver02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class RequestHandler extends Thread{
    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);

    private Socket connection;

    public RequestHandler(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        log.debug("New Client Connect! Connected IP : {}, Port : {}, Host Address : {}", connection.getInetAddress(), connection.getPort(), connection.getInetAddress().getHostAddress());

        try(InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

            String line = " ";

            StringBuffer resultContent = new StringBuffer();
            while (!"".equals(line)){
                line = bufferedReader.readLine();

                if( line == null ) return;

                if(line.indexOf("index.html") > 0){
                    InputStream inputStream = RequestHandler.class.getResourceAsStream("templa:q!@:q/tes/index.html");

                    BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream));

                    while (!"".equals(line)){
                        line = bufferedReader1.readLine();

                        if(line == null) return;

                        resultContent.append(line);
                    }
                }


                log.debug("Buffered Reader : {}", line );
            }

            DataOutputStream dos = new DataOutputStream(out);
            byte[] body = resultContent.toString().getBytes(StandardCharsets.UTF_8);
            response200Header(dos, body.length);
            responseBody(dos, body);
        }catch (Exception exception){
            log.error(exception.getMessage());
        }
    }

    private void response200Header(DataOutputStream dos, int lengthOfBodyContent){
        try{
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8 \r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        }catch (Exception exception){
            log.error(exception.getMessage());
        }
    }

    private void responseBody(DataOutputStream dos, byte[] body){
        try{
            dos.write(body, 0, body.length);
            dos.writeBytes("\r\n");
            dos.flush();
        }catch (Exception exception){
            exception.getMessage();
        }
    }
}
