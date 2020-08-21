package lines.queue.controller;

import lines.queue.handler.QueueHandler;
import lines.queue.model.RequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@EnableWebFlux
@Slf4j
public class QueueManager {

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return route(POST("/hello"), req -> req.body(toMono(RequestVO.class)).log().doOnNext(item -> log.info(item.toString())).then(ok().build()));
    }

    @Bean
    public RouterFunction<ServerResponse> testRoutes(QueueHandler queueHandler){
        return RouterFunctions.route(POST("/addQueue"), queueHandler::addItem)
                .andRoute(GET("/getQueue/{parameterKey}"), queueHandler::getItem );
    }
}
