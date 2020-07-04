package lines.nonblockingwebflux.handler;

import lines.nonblockingwebflux.model.DemoModel;
import lines.nonblockingwebflux.model.DemoResponse;
import lines.nonblockingwebflux.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@Component
@RequiredArgsConstructor
public class DemoHandler {
    private final DemoService demoService;

    public Mono<ServerResponse> post(ServerRequest serverRequest) {

        Flux<DemoResponse> ret = demoService.post(
                serverRequest.bodyToFlux(DemoModel.class)
                        .filter(demoModel -> {

                            //Set<ConstraintViolation<DemoModel>> validationResult = validator.validate(demoModel);

                            //if (validationResult.isEmpty()) {

                                return true;

                            //} else {

                            //    return false;

                            //}

                        })

        );

        return ServerResponse.ok().body(ret, DemoResponse.class);

    }

}
