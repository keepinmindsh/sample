package lines.reactivewebflux.sample02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@RestController
@Slf4j
public class SpringBootSampleApplication {

   /*
   * Mono를 반환하는게 어떤 의미를 가지는가?
   * */

    @GetMapping("/")
    Mono<String> hello(){
        log.info("pos1");
        Mono<String> m = Mono.fromSupplier(() -> generateHello()).doOnNext(c -> log.info(c)).log();  // Publisher -> ( Publisher ) -> ( Publisher ) -> Subscriber
        String msg = m.block();
        log.info("pos2 : " + msg);
        return Mono.just(msg);
    }

    private String generateHello() {
        log.info("Method generatedHello");
        return "Hello Mono";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }
}
