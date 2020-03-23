package lines.reactive.sample.child1;

import lines.reactive.sample.parent.IHomeService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("lines.reactive.sample.child1")
@PropertySource("classpath:ctx1.properties")
@EnableAutoConfiguration
public class Ctx1Config {

    @Bean
    public IHomeService homeService(){
        return new GreetingService();
    }
}
