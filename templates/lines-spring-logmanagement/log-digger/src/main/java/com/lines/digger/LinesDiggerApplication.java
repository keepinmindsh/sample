package com.lines.digger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan({"com.lines"})
public class LinesDiggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LinesDiggerApplication.class, args);
    }
}
