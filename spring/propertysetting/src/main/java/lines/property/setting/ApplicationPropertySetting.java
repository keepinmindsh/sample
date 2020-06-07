package lines.property.setting;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ApplicationPropertySetting {

    private static Environment environment;

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .profiles("local")
                //.properties("spring.config.location=classpath:/application-local.yml")
                .parent(ApplicationPropertySetting.class).web(WebApplicationType.NONE)
                .child(Controller.class).web(WebApplicationType.SERVLET)
                .run(args);


        log.info("Profile List : {} " ,environment.getActiveProfiles());
    }

    @RestController
    @Configuration
    @EnableAutoConfiguration
    public static class Controller{

        @GetMapping
        public Object callMethod(){
            return "Hello World";
        }
    }
}
