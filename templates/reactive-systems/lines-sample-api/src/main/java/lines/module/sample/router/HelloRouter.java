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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
@RequiredArgsConstructor
public class HelloRouter {

    //private final HelloRepository helloRepository;

    @RouterOperations({
            @RouterOperation(path="/hello", operation = @Operation(operationId = "hello", summary = "Hello World", tags = {"HelloWorld"})),
            @RouterOperation(path="/hello/get", operation = @Operation(operationId = "hello get", summary = "Hello GET", tags = {"HelloWorld"})),
    })
    @Bean
    public RouterFunction<ServerResponse> routeForHello(HelloHandler helloHandler){
        return
                RouterFunctions.route(
                        RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), ( request -> helloHandler.hello(request))
                ).andRoute(
                        RequestPredicates.GET("/helloWithThreeSeconds").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), ( request -> {
                    try {
                        return helloHandler.helloWithThreeSeconds(request);
                    } catch (Exception e) {
                        return null;
                    }
                }))
                .andRoute(
                        RequestPredicates.POST("/hello").and(RequestPredicates.accept(MediaType.ALL)), ( request -> helloHandler.helloPost(request))
                );
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
