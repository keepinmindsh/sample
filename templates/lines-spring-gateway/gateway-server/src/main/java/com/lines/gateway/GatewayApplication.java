package com.lines.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {

    // TODO http://dveamer.github.io/backend/SpringCloudGateway.html 참고 해서 부하분산 적용하기

    // TODO https://m.blog.naver.com/gngh0101/222106724959 Spring Cloud Loadbalancer

    // TODO https://github.com/spring-guides/gs-spring-cloud-loadbalancer 기본 자료 활용 - 샘플보고 적용할 것

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
