package lines.queue.handler;

import lines.queue.model.RequestVO;
import lines.queue.storage.QueueStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class QueueHandler {
    public Mono<ServerResponse> addItem(ServerRequest serverRequest){

        Mono<RequestVO> requestVOMono = serverRequest.bodyToMono(RequestVO.class);

        return ServerResponse
                    .ok()
                    .body(requestVOMono.log()
                                        .map(item -> {
                                            log.info(item.toString());

                                            QueueStorage.addItem(item.getParameterKey(), Mono.just(item));
                                            return item;
                                        }).then(), RequestVO.class);
    }

    public Mono<ServerResponse> getItem(ServerRequest serverRequest){

        log.info("Parameter Key : {}", serverRequest.pathVariable("parameterKey"));

        return ServerResponse
                .ok()
                .body(QueueStorage.
                                <String, Mono<RequestVO>>getItem(serverRequest.pathVariable("parameterKey"))
                                .log()
                                .then(),
                        RequestVO.class);
    }
}
