package com.lines.basic.webserver03;

import com.lines.basic.webserver03.mapper.ModelMapper;
import com.lines.basic.webserver03.mapper.ParserType;
import com.lines.basic.webserver03.resourceviews.Resource;
import com.lines.basic.webserver03.resourceviews.factory.ResourceFactory;
import com.lines.basic.webserver03.resourceviews.ResourceParam;
import com.lines.basic.webserver03.resourceviews.ResourceType;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

@Slf4j
public class RequestHandler extends Thread{

    private static final ModelMapper<String, String> modelmapper = new ModelMapper();

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

            byte[] body = null;

            do {
                line = bufferedReader.readLine();

                if(line != null && line.indexOf("GET") > -1 && line.indexOf(".html") > -1){

                    String screenName = modelmapper.parse(ParserType.ViewString , line);

                    log.info("screenName : {}", screenName);

                    Resource resource = ResourceFactory.getResource(ResourceType.VIEW_HTML,
                            ResourceParam.builder()
                                .screen(screenName)
                                .build());

                    body = (byte[]) resource.call();
                }else{
                    String urlName = modelmapper.parse(ParserType.QueryString , line);

                    log.info("urlName : {}", urlName);

                    Resource resource = ResourceFactory.getResource(ResourceType.DATA,
                                ResourceParam
                                        .builder()
                                        .url(urlName)
                                        .build()
                            );

                    body = (byte[]) resource.call();
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
