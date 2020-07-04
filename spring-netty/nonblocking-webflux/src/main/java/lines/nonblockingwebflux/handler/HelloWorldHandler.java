package lines.nonblockingwebflux.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
public class HelloWorldHandler {
    public Mono<ServerResponse> handleRequest(ServerRequest serverRequest) {

        log.info("Call!");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("에러 발생" + e.getLocalizedMessage());
        }

        return ServerResponse.ok().body(Mono.just("Hello World!"), String.class);
    }
}
