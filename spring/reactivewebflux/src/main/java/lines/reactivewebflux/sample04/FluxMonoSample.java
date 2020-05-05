package lines.reactivewebflux.sample04;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class FluxMonoSample {
    public static void main(String[] args) {

        log.info("[ START ]========================= Publisher : Flux 의 다양한 예제 ================================");

        Flux<String> stringFlux = Flux.just("foo", "bar", "foobar");

        List<String> stringList = Arrays.asList("foo", "bar", "foobar");

        Flux<String> stringFlux1 = Flux.fromIterable(stringList);

        stringFlux.subscribe(item -> System.out.println(item));

        stringFlux1.subscribe(item -> System.out.println(item));

        Flux<Integer> integerFlux = Flux.range(3, 10);

        integerFlux.subscribe(item -> System.out.println(item));

        log.info("[  END  ]========================= Publisher : Flux 의 다양한 예제 ================================");
        log.info("[ START ]========================= Publisher : Subscribe 의 다양한 예제 ================================");

        Flux<Object> integerFlux1 = Flux.range(3, 10).collectMap(item1 -> {
            log.info("integerFlux1 - collectMap : {}" ,item1 + 1);
            return item1 + 1;
        }).flatMapIterable(itemMap -> {

            int sumTotal = 0;

            for (Object object :
                    itemMap.keySet()) {
                log.info("integerFlux1 - flatMapIterable : {}" , itemMap.get(object).toString());

                sumTotal += Integer.parseInt(itemMap.get(object).toString());
            }

            return null;
        }).log();

        integerFlux1.subscribe(item -> System.out.println(item), error -> log.error("에러발생 " + error.getMessage()));

        integerFlux1.subscribe(item -> System.out.println(item), error -> log.error("에러발생 " + error.getMessage()), () -> log.info("It totally has been finished."));

        log.info("[  END  ]========================= Publisher : Subscribe 의 다양한 예제 ================================");
        log.info("[ START ]========================= Publisher : Mono 의 다양한 예제 ================================");


        Mono<String> stringMono = Mono.empty();

        Mono<String> stringMono1 = Mono.just("foo");

        stringMono.subscribe(item -> System.out.println(item));

        stringMono1.subscribe(item -> System.out.println(item));

        log.info("[  END  ]========================= Publisher : Mono 의 다양한 예제 ================================");
        log.info("[ START ]========================= Publisher : Subscribe 의 다양한 예제 ================================");

        Flux<Integer> integerFlux2 = Flux.range(1,3);
        integerFlux2.subscribe(item -> System.out.println(item));

        Flux<Integer> integerFlux3 = Flux.range(1,10)
                .map(i -> {
                    if( i <= 9) return i;
                    else throw new RuntimeException("Error!");
                });

        integerFlux3.subscribe(i -> log.info("Value {}", i), error -> log.error(error.getMessage()));

        Flux<Integer> integerFlux4 = Flux.range(1,10)
                .map(i -> {
                    if( i <= 10) return i;
                    else throw new RuntimeException("Error!");
                });

        integerFlux4.subscribe(i -> log.info("Value {}", i), error -> log.error(error.getMessage()), () -> log.info("Done"));

        integerFlux4.subscribe(i -> log.info("Value {}", i), error -> log.error(error.getMessage()), () -> log.info("Done"), sub -> sub.request(30));

        log.info("[  END  ]========================= Publisher : Subscribe 의 다양한 예제 ================================");
    }
}
