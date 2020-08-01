package lines.module.sample.handler;

import lines.module.sample.entity.HelloEntity;
import lines.module.sample.repository.HelloRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class HelloHandler {

    private final HelloRepository repository;

    public HelloHandler(HelloRepository repository) {
        this.repository = repository;
    }

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello, Spring!"));
    }

    public Mono<ServerResponse> getHello(ServerRequest serverRequest){
        Flux<HelloEntity> listMono = this.repository.findAllBy();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(listMono, HelloEntity.class);
    }
}
