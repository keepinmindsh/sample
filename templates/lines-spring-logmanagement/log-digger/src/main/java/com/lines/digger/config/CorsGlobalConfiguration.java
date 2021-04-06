package com.lines.digger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class CorsGlobalConfiguration implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")
                .allowedOrigins("http://localhost:5000")
                .allowedMethods("*")
                .maxAge(3600);
    }
}
