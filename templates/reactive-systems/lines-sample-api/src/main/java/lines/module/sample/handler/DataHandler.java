package lines.module.sample.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class DataHandler {

    public Mono<ServerResponse> getData(ServerRequest serverRequest){

        log.info("Path Request :  {}", serverRequest.pathVariable("id"));

        serverRequest.bodyToMono(String.class).log().doOnNext(item -> log.info(item)).subscribe();

        return ServerResponse.ok().body(BodyInserters.empty());
    }
}
