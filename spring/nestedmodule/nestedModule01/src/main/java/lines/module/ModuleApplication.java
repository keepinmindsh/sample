package lines.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("lines.module")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ModuleApplication.class);
    }
}
