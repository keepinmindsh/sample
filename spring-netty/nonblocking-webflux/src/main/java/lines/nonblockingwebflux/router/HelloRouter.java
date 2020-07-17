package lines.nonblockingwebflux.router;

import lines.nonblockingwebflux.handler.DemoHandler;
import lines.nonblockingwebflux.handler.HelloWorldHandler;
import lines.nonblockingwebflux.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class HelloRouter {

    @Bean
    HelloWorldHandler helloWorldHandler(){
        return new HelloWorldHandler();
    }

    @Bean
    RouterFunction<ServerResponse> helloRouterFunction(HelloWorldHandler helloWorldHandler){
        return RouterFunctions.route(RequestPredicates.path("/"), helloWorldHandler::handleRequest);
    }

    @Bean
    public RouterFunction<ServerResponse> routes(DemoHandler demoHandler) {

        return RouterFunctions
                .route(RequestPredicates.GET("/demo").and(contentType(APPLICATION_JSON)), demoHandler::post);

    }

    @Bean
    RouterFunction<ServerResponse> home() {
        return RouterFunctions.route(RequestPredicates.GET("/homepage"), request -> ok().body(fromValue("Home page")));
    }
}
