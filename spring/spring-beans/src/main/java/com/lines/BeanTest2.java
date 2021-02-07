package com.lines;

import com.lines.singleton.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class BeanTest2 {

    private final Single single;

    @PostConstruct
    public void run(){
        log.info("Address Memory : {}" , single.toString());
    }
}
