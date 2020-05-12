package lines.reactivewebflux.sample05;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CombiningSample {
    public static void main(String[] args) {
        List<Object> integerList = new ArrayList<>();

        Flux.just(1,2,3,4)
                .log()
                .map(i -> i * 2)
                .zipWith(Flux.range(0 , Integer.MAX_VALUE),
                        (one, two) -> String.format("First Flux : %d, Second Flux : %d", one, two)
                        )
                .subscribe(integerList::add);

        integerList.forEach(item -> {
            log.info("Value : {}", item);
        });
    }
}
