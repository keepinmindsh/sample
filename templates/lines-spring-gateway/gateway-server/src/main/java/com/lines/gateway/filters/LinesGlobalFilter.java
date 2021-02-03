package com.lines.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class LinesGlobalFilter extends AbstractGatewayFilterFactory<LinesGlobalFilter.Config> {

    public LinesGlobalFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        System.out.println("inside GlobalFilter");

        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest().mutate().header("LinesGlobalFilter", Math.random()*10 + " ").build();

            return chain.filter(exchange.mutate().request(request).build());
        };
    }

    public static class Config {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }
}
