package lines.reactivewebflux.ProjectReactorCoreSample.sample05;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class HotSample {
    public static void main(String[] args) {
        ConnectableFlux<Object> objectConnectableFlux = Flux.create(objectFluxSink -> {
           while(true){
               objectFluxSink.next(System.currentTimeMillis());
           }
        }).publish();

        objectConnectableFlux.subscribe(System.out::println);
        objectConnectableFlux.subscribe(System.out::println);

        objectConnectableFlux.map(item -> {
            return item + "1";
        });

        objectConnectableFlux.connect();
    }
}
