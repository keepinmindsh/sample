package lines.reactivewebflux.ProjectReactorCoreSample.sample05;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import static java.time.Duration.ofSeconds;

public class ThrottlingSample {
    public static void main(String[] args) {

        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
            while(true) {
                fluxSink.next(System.currentTimeMillis());
            }
        })
                .sample(ofSeconds(2))
                .publish();

        publish.log();


        publish.connect();
    }
}
