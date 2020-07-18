package lines.nonblockingwebflux.router;

import lines.nonblockingwebflux.handler.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class BookRouter {
//    @Bean
//    public RouterFunction<ServerResponse> route(BookHandler handler) {
//        return RouterFunctions
//                .route(RequestPredicates.GET("/fbooks").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
//                .andRoute(RequestPredicates.GET("/fbook/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById)
//                .andRoute(RequestPredicates.POST("/fbook").and(accept(MediaType.APPLICATION_JSON)), handler::save)
//                .andRoute(RequestPredicates.DELETE("/fbook/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
//    }
}
