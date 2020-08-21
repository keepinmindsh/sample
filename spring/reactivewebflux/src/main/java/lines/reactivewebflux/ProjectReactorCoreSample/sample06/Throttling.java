package lines.reactivewebflux.ProjectReactorCoreSample.sample06;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Throttling {
    public static void main(String[] args) {
        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
            while (true){
                fluxSink.next(System.currentTimeMillis());
            }
        })
                .sample(Duration.ofSeconds(2))
                .publish();

        //publish.connect();
    }
}
