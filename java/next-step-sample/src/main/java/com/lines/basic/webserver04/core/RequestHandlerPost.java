package com.lines.basic.webserver04.core;

import com.lines.basic.webserver04.core.mapper.ModelMapper;
import com.lines.basic.webserver04.core.mapper.ModelParam;
import com.lines.basic.webserver04.core.mapper.code.ParserType;
import com.lines.basic.webserver04.core.resourceviews.Resource;
import com.lines.basic.webserver04.core.resourceviews.ResourceParam;
import com.lines.basic.webserver04.core.resourceviews.code.ResourceType;
import com.lines.basic.webserver04.core.resourceviews.factory.ResourceFactory;
import com.lines.basic.webserver04.domain.user.controller.UserMapping;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.stream.Collectors;

public class RequestHandlerPost extends Thread{

    private static final Logger log = LoggerFactory.getLogger(RequestHandlerPost.class);
    private static final ModelMapper<String, String> modelmapperForString = new ModelMapper();
    private static final ModelMapper<String, Object> modelmapperForObject = new ModelMapper();

    private Socket connection;

    public RequestHandlerPost(Socket connection) {
        this.connection = connection;
    }

    // TODO - 엄청 궁금한 부분이 생김 - form.html을 초기 로딩 이후에 form.html에 일부분을 수정하고 저장한뒤 재조회를 하더라고 서비스를 끄지 않으면 계속 동일한 값이 표시됨 - 해당 부분에 대해서 확인 필요
    @Override
    public void run() {
        log.debug("New Client Connect! Connected IP : {}, Port : {}, Host Address : {}", connection.getInetAddress(), connection.getPort(), connection.getInetAddress().getHostAddress());

        try(InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

            byte[] body = getBytesFromRequest(bufferedReader);

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

    private byte[] getBytesFromRequest(BufferedReader bufferedReader) throws Exception {
        // TODO 아래의 코드가 확인 중 - POST 전송시 제대로 호출되지 않음.
        String line = bufferedReader.readLine();

        log.info("line - {}", line);

        if(isIco(line)) return null;

        byte[] body = null;

        if(isGet(line)){
            String screenName = modelmapperForString.parse(ParserType.ViewString , line);

            log.debug("screenName : {}", screenName);

            Resource resource = ResourceFactory.getResource(ResourceType.VIEW_HTML,
                    ResourceParam.builder()
                        .screen(screenName)
                        .build());

            body = (byte[]) resource.call();
        }else if(isPost(line, "POST")){
            // TODO - Socket을 통해서 들어온 데이터에 대해서 content-length를 지정해서 자르지 않을 경우 제대로 동작하지 않는 이유는?
            String lineForPost = null;

            int contentLength = 0;

            while (!(lineForPost = bufferedReader.readLine()).equals("")){
                log.info("Result : {} {}", lineForPost, Optional.ofNullable(lineForPost).isPresent());

                if(lineForPost.contains("Content-Length")){
                    contentLength = Integer.valueOf(lineForPost.replace("Content-Length:", "").trim());
                    log.info("check content length : {}", contentLength );
                }
            }

            char[] charArray = new char[contentLength];
            bufferedReader.read(charArray, 0, contentLength);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.insert(0, charArray);

            lineForPost =  stringBuilder.toString();
            log.info("form data : {}", lineForPost);

            log.info("mapping data : {}", modelmapperForObject.parse(ParserType.CustomMapping ,
                    ModelParam.builder()
                            .mapping(new UserMapping(lineForPost))
                            .build()
            ));

            //log.info("form data : {}",  IOUtils.toString(bufferedReader));
            //log.info("buffer checked length : {}", bufferedReader.lines().collect(Collectors.joining()));

            /*
            String urlName = modelmapperForObject.parse(ParserType.CustomMapping,line).toString();

            log.debug("urlName : {}", urlName);

            Resource resource = ResourceFactory.getResource(ResourceType.DATA,
                    ResourceParam.builder()
                            .screen(urlName)
                            .build());

            body = (byte[]) resource.call();
            */
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

        return body;
    }

    private boolean isPost(String line, String post) {
        return line != null && line.indexOf(post) > -1;
    }

    private boolean isIco(String line) {
        return line != null && line.indexOf(".ico") > -1;
    }

    private boolean isGet(String line) {
        return line != null && line.indexOf("GET") > -1 && line.indexOf(".html") > -1;
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
