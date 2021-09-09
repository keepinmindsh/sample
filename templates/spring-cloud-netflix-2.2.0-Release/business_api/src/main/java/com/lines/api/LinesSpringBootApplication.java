package com.lines.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@EnableHystrixDashboard
@SpringBootApplication
@Log
public class LinesSpringBootApplication {

    @GetMapping("/call_test")
    public String helloWorld(){
        try {
            Thread.sleep(30000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "Hello World";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(LinesSpringBootApplication.class, args);
    }
}
