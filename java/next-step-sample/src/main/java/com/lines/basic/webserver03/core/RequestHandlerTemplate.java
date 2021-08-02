package com.lines.basic.webserver03.core;

import com.lines.basic.webserver03.core.mapper.ModelMapper;
import com.lines.basic.webserver03.core.mapper.ModelParam;
import com.lines.basic.webserver03.core.mapper.code.ParserType;
import com.lines.basic.webserver03.core.resourceviews.Resource;
import com.lines.basic.webserver03.core.resourceviews.ResourceParam;
import com.lines.basic.webserver03.core.resourceviews.code.ResourceType;
import com.lines.basic.webserver03.core.resourceviews.factory.ResourceFactory;
import com.lines.basic.webserver03.domain.user.controller.UserMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class RequestHandlerTemplate extends Thread{

    private static final Logger log = LoggerFactory.getLogger(RequestHandlerTemplate.class);
    private static final ModelMapper<String, String> modelmapperForString = new ModelMapper();
    private static final ModelMapper<String, Object> modelmapperForObject = new ModelMapper();

    private Socket connection;

    public RequestHandlerTemplate(Socket connection) {
        this.connection = connection;
    }

    // TODO - 엄청 궁금한 부분이 생김 - form.html을 초기 로딩 이후에 form.html에 일부분을 수정하고 저장한뒤 재조회를 하더라고 서비스를 끄지 않으면 계속 동일한 값이 표시됨 - 해당 부분에 대해서 확인 필요
    @Override
    public void run() {
        log.debug("New Client Connect! Connected IP : {}, Port : {}, Host Address : {}", connection.getInetAddress(), connection.getPort(), connection.getInetAddress().getHostAddress());

        try(InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String line = " ";

            byte[] body = null;

            do {
                line = bufferedReader.readLine();

                if(line.indexOf(".ico") > -1) return;

                if(line != null && line.indexOf("GET") > -1 && line.indexOf(".html") > -1){

                    String screenName = modelmapperForString.parse(ParserType.ViewString , line);

                    log.debug("screenName : {}", screenName);

                    Resource resource = ResourceFactory.getResource(ResourceType.VIEW_HTML,
                            ResourceParam.builder()
                                .screen(screenName)
                                .build());

                    body = (byte[]) resource.call();
                }else{
                    String urlName = "";

                    if(line.indexOf("/user/create") > -1){

                        line = line.split("\\?")[1];

                        urlName = modelmapperForObject.parse(ParserType.CustomMapping ,
                                ModelParam.builder()
                                        .mapping(new UserMapping(line))
                                .build()
                        ).toString();
                    }else{
                        urlName = modelmapperForString.parse(ParserType.QueryString , line);
                    }


                    log.debug("urlName : {}", urlName);

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
