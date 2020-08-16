package lines.reactivewebflux.routerSample;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.reactive.HiddenHttpMethodFilter;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableWebFlux
public class ExampleApplication {

    @Bean
    HelloWorldHandler helloWorldHandler(){
        return new HelloWorldHandler();
    }

    @Bean
    RouterFunction<ServerResponse> helloRouterFunction(HelloWorldHandler helloWorldHandler){
        return RouterFunctions.route(RequestPredicates.path("/"), helloWorldHandler::handleRequest);
    }

    public static void main(String[] args) throws Exception{
        new SpringApplicationBuilder().parent(ExampleApplication.class).web(WebApplicationType.REACTIVE).build().run(args);
    }

    @Bean
    HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
