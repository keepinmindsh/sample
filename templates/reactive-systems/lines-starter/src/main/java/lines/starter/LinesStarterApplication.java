package lines.starter;

import lines.module.sample.SampleContextConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class LinesStarterApplication {

    @Configuration
    @EnableAutoConfiguration
    @EnableDiscoveryClient
    @ComponentScan(
        "lines.connection"
    )
    static class WebConfiguration {

    }

    public static void main(String[] args) {

        new SpringApplicationBuilder()
                .parent(LinesStarterApplication.class).web(WebApplicationType.NONE)
                .child(new Class[]{
                        WebConfiguration.class,
                        SampleContextConfiguration.class
                }).web(WebApplicationType.REACTIVE)
                .run(args);
    }
}
