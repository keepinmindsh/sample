package lines.module.sample.handler;

import lines.module.sample.model.RequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class HelloHandler {


    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello, Spring!"));
    }

    public Mono<ServerResponse> helloPost(ServerRequest request) {

        Mono<String> requestVOMono = request.bodyToMono(String.class);

        requestVOMono
                .log()
                .doOnNext(item -> {
                    log.info("Data Check : {}", item.toString());
                })
                .map(item -> {
                    log.info("Data Check : {}", item.toString());
                    return item;
                })
                .subscribe(item -> {
                    log.info("Value : {}", item.toString());
                });

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello, Spring!"));
    }

    public Mono<ServerResponse> helloWithThreeSeconds(ServerRequest serverRequest) throws Exception {

        Thread.sleep(3000);

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello, Spring!"));
    }
}
