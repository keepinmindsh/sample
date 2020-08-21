package lines.reactivewebflux.ProjectReactorCoreSample.sample06;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class CreatingConnectableFlux {
    public static void main(String[] args) {
        ConnectableFlux<Object> publish = Flux.create(objectFluxSink -> {
            while (true){
                objectFluxSink.next(System.currentTimeMillis());
            }
        }).publish();

        publish.subscribe(System.out::println);
        publish.subscribe(System.out::println);

        // connect()가 호출되기 전까지 위의 코드는 실행되지 않는다.
        //publish.connect();
    }
}
