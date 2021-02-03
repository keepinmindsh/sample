package com.lines.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class LinesPreFilter extends AbstractGatewayFilterFactory<LinesPreFilter.Config> {

    public LinesPreFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        System.out.println("inside SCGWPreFilter.apply method");

        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest().mutate().header("scgw-pre-header", Math.random()*10+"").build();
            return chain.filter(exchange.mutate().request(request).build());
        };
    }

    public static class Config {
        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
