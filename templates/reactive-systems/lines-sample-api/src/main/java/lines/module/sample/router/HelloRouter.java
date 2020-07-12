package lines.module.sample.router;

import io.swagger.v3.oas.annotations.Operation;
import lines.module.sample.handler.HelloHandler;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HelloRouter {

    @RouterOperation(operation = @Operation(operationId = "hello", summary = "Hello World", tags = { "HelloWorld" }))
    @Bean
    public RouterFunction<ServerResponse> route(HelloHandler helloHandler){
        return RouterFunctions.route(RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), helloHandler::hello);
    }
}
