package lines.module.sample.handler;

import lines.module.sample.model.RequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ReactiveHttpInputMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractor;
import org.springframework.web.reactive.function.BodyExtractors;
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

    public Mono<ServerResponse> insertData(ServerRequest serverRequest){

        Mono<RequestVO> requestVOMono = serverRequest.bodyToMono(RequestVO.class);

//        serverRequest.body(BodyExtractors.toMono(RequestVO.class))
//                .subscribe(item -> {
//                    log.info("Subscribe : {}" , item);
//                });

        requestVOMono.log()
                .doOnNext(item -> {
                    log.info("Request Param : {}", item);
                })
                .subscribe(item -> {
                    log.info("Subscribe : {}", item);
                });

        return ServerResponse.ok().body(BodyInserters.empty());
    }

    public Mono<ServerResponse> selectData(ServerRequest serverRequest){
        BodyExtractor<Mono<RequestVO>, ReactiveHttpInputMessage> extractor = BodyExtractors.toMono(RequestVO.class);

        serverRequest.body(extractor)
                .subscribe(item -> {
                    log.info("Spring Data : {}", item);
                });

        return ServerResponse.ok().body(BodyInserters.fromValue("Hellowold"));
    }
}
