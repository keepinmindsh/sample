package lines.nonblockingwebflux.service;

import lines.nonblockingwebflux.model.DemoModel;
import lines.nonblockingwebflux.model.DemoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class DemoService {
    public Flux<DemoResponse> post(Flux<DemoModel> demoModelFlux) {

        return demoModelFlux.
                flatMap(demoModel -> {
                    log.debug("demoModel : {}", demoModel);
                    return Flux.just(new DemoResponse(demoModel, true));
                });

    }

}
