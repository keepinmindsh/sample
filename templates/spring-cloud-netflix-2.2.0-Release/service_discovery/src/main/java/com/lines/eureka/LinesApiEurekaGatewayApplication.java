package com.lines.eureka;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Component;

import java.util.Map;

@SpringBootApplication
@EnableZuulProxy
@EnableCircuitBreaker
@EnableDiscoveryClient
public class LinesApiEurekaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinesApiEurekaGatewayApplication.class, args);
	}

}

// TODO - hystrix에 대한 이해 필요
@Component
class StoreIntegration {

	@HystrixCommand(fallbackMethod = "defaultStores")
	public Object getStores(Map<String, Object> parameters) {
		return "test";
	}

	public Object defaultStores(Map<String, Object> parameters) {
		return "test";
	}
}

