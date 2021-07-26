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
            while (line != null){
                line = bufferedReader.readLine();

                log.debug("Http Content : {}", line );

//                if( line == null ) return;
                // TODO - 해당 코드 실행시 응답값이 제대로 반환되지 않음.

                if(line.indexOf("index.html") > 0){
                    InputStream inputStream = new FileInputStream("/Users/dream/GIT/sample/java/next-step-sample/src/main/resources/templates/index.html");

                    BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream));

                    while (line != null){
                        line = bufferedReader1.readLine();

                        log.info("{}", line);

                        if(line == null) return;

                        resultContent.append(line + "\r\n");
                    }
                }


                log.debug("Buffered Reader : {}", line );
            }

            // TODO 해당 부분부터 다시 코딩 체크 시작

            DataOutputStream dos = new DataOutputStream(out);
            byte[] body = resultContent.toString().getBytes(StandardCharsets.UTF_8);
            response200Header(dos, body.length);
            responseBody(dos, body);
        }catch (Exception exception){
            log.error(exception.getMessage());
            exception.printStackTrace();
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
