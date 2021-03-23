package com.lines.digger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class LinesDiggerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder().parent(LinesDiggerApplication.class).web(WebApplicationType.REACTIVE).build().run(args);
    }
}
