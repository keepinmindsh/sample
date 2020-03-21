package lines.sample.child2;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("lines.sample.child2")
@PropertySource("classpath:ctx2.properties")
@EnableAutoConfiguration
public class Ctx2Config {

}
