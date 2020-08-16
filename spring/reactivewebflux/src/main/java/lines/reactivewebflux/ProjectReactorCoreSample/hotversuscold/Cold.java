package lines.reactivewebflux.ProjectReactorCoreSample.hotversuscold;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Slf4j
public class Cold {
    public static void main(String[] args) {
        Flux<String> source = Flux.fromIterable(Arrays.asList("blue", "green", "orange", "purple"))
                                    .map(String::toUpperCase);

        source.subscribe(item -> log.info("Subscriber 1 : {}", item));
        source.subscribe(item -> log.info("Subscriber 2 : {}", item));
    }
}
