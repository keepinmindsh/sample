package com.lines.basic.webserver02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

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
            byte[] body = null;

            do {

                line = bufferedReader.readLine();

                if(line != null && line.indexOf("GET") > -1 && line.indexOf(".html") > -1){

                    String screenName = line.split(" ")[1];
                    // body = Files.readAllBytes(new File("/Users/dream/GIT/sample/java/next-step-sample/src/main/resources/templates/index.html").toPath());
                    // body = Files.readAllBytes(new File("D:/GIT/01_GIT/02_sample/java/next-step-sample/src/main/resources/templates/index.html").toPath());

                    //Class clazz = RequestHandler.class;
                    //body = Files.readAllBytes(new File(clazz.getResource("/templates/index.html").getFile()).toPath());

                    //Class clazz = RequestHandler.class;
                    //InputStream inputStream = clazz.getResourceAsStream("/templates/index.html");
                    //log.info("Length Size : {}" , inputStream.available());
                    //body = inputStream.readAllBytes();

                    body = RequestHandler
                            .class
                            .getResourceAsStream("/templates" + screenName)
                            .readAllBytes();
                }
            } while (body == null);

            if(body != null){
                DataOutputStream dos = new DataOutputStream(out);
                response200Header(dos, body.length);
                responseBody(dos, body);
            }
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
            exception.printStackTrace();
            log.error(exception.getMessage());
        }
    }
}
