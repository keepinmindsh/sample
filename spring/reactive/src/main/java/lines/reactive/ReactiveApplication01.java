package lines.reactive;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ReactiveApplication01 {

    private static Logger logger = LoggerFactory.getLogger(ReactiveApplication01.class);

    @Component
    public static class MyService{
        public String hello() throws InterruptedException {
            logger.debug("Hello()");
            Thread.sleep(1000);
            return "Hello";
        }
    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ReactiveApplication01.class)) {

        }
    }

    @Autowired MyService myService;

    @Bean
    ApplicationRunner run(){
        return args -> {
            logger.info("run()");

            String res = myService.hello();

            logger.info("exit: " + res);

        };
    }
}
