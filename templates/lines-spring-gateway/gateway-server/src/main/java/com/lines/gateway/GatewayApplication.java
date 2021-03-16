package com.lines.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {

    // TODO http://dveamer.github.io/backend/SpringCloudGateway.html 참고 해서 부하분산 적용하기

    // TODO https://m.blog.naver.com/gngh0101/222106724959 Spring Cloud Loadbalancer

    // TODO https://github.com/spring-guides/gs-spring-cloud-loadbalancer 기본 자료 활용 - 샘플보고 적용할 것

    // TODO https://happycloud-lee.tistory.com/221 보고 참고해서 구성을 변경해볼 것

    // TODO https://o7planning.org/11739/undertanding-load-balancing-in-spring-cloud-with-ribbon-and-example ribbon 구성

    // TODO https://piotrminkowski.com/2020/05/13/a-deep-dive-into-spring-cloud-load-balancer/

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
