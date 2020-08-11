package lines.module.sample.router;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lines.module.sample.handler.DataHandler;
import lines.module.sample.handler.HelloHandler;
import lines.module.sample.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class HelloRouter {

    private final HelloRepository helloRepository;

    public HelloRouter(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @RouterOperations({
            @RouterOperation(path="/hello", operation = @Operation(operationId = "hello", summary = "Hello World", tags = {"HelloWorld"})),
            @RouterOperation(path="/hello/get", operation = @Operation(operationId = "hello get", summary = "Hello GET", tags = {"HelloWorld"})),
    })
    @Bean
    public RouterFunction<ServerResponse> routeForHello(HelloHandler helloHandler){
        return
                RouterFunctions.route(RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), ( request -> {
                    return helloHandler.hello(request, helloRepository);
                }));
    }

    @RouterOperations({
            @RouterOperation(path="/data/{id}", operation = @Operation(operationId = "data", summary = "Data World", tags = { "Data World" }, parameters = { @Parameter(in = ParameterIn.PATH, name = "id", description = "Employee Id") })),
            @RouterOperation(path="/data/insert", operation = @Operation(operationId = "data", summary = "Data World", tags = { "Data World" }, parameters = { @Parameter(in = ParameterIn.PATH, name = "id", description = "Employee Id") })),
    })
    @Bean
    public RouterFunction<ServerResponse> routeForData(DataHandler dataHandler){
        return RouterFunctions.route(RequestPredicates.GET("/data/{id}").and(RequestPredicates.accept(MediaType.ALL)), dataHandler::getData)
                .andRoute(RequestPredicates.POST("/data/insert").and(RequestPredicates.accept(MediaType.ALL)), dataHandler::insertData)
                .andRoute(RequestPredicates.GET("/data/select").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), dataHandler::selectData)
                ;
    }
}
