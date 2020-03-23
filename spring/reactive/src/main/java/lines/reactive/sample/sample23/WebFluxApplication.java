package lines.reactive.sample.sample23;

import lines.reactive.sample.sample08.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFlux
public class WebFluxApplication {

    // https://kimyhcj.tistory.com/343

    @Bean
    public RouterFunction<ServerResponse> routes(){
        //return RouterFunctions.route(GET("/userFunc"), handler::findByName);

        return null;
    }



    public static void main(String[] args) {

    }
}

@Component
@RequiredArgsConstructor
class TestHandler {
    private  final Service service;

    public Mono<ServerResponse> findByName(ServerRequest request){
      //Mono<User> user = Mono.just(service.fin)
      return null;
    };
}