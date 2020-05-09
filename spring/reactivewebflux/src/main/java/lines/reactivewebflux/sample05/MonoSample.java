package lines.reactivewebflux.sample05;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class MonoSample {
    public static void main(String[] args) {
        Mono<String> just = Mono.just("foo");

        just.subscribe(item ->{
            log.info("Value : {}", item);
        });
    }
}
