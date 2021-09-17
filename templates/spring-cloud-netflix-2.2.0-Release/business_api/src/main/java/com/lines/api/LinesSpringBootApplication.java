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
        System.out.println("111111111");
        try {
            Thread.sleep(10000);
            System.out.println("222222222222222222222222");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "Hello World";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/info")
    public String info(){
        return "info";
    }

    @GetMapping("/health")
    public String health(){
        return "health";
    }

    public static void main(String[] args) {
        SpringApplication.run(LinesSpringBootApplication.class, args);
    }
}
