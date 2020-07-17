package lines.reactivewebflux.sample06;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class MappingDataInStream {
    public static void main(String[] args) {
        Flux.just(1 , 2, 3, 4)
                .log()
                .map(i -> i * 2)
                .subscribe(item -> log.info("Spring Data : {}", item) );
    }
}
