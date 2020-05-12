package lines.reactivewebflux.sample05;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class MappingSample {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();

        Flux.just(1,2,3,4)
                .log()
                .map(i -> i * 2)
                .subscribe(integerList::add);
    }
}
