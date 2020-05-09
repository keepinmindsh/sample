package lines.reactivewebflux.sample05;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class CollectingSample {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        Flux.just(1,2,3,4)
                .log()
                .subscribe(integerList::add);

        Stream.generate(() -> Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList())).limit(100);

        Flux.just(
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()),
                    Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList())
                )
                .log()
                .subscribe(new BaseSubscriber<List<Integer>>() {

                    AtomicInteger atomicInteger = new AtomicInteger();

                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(5);
                    }

                    @Override
                    protected void hookOnNext(List<Integer> value) {

                        int integerValue = atomicInteger.incrementAndGet();

                        for (Integer integer : value) {
                            log.info("Value Item: {} , number : {} ", integer, integerValue);
                        }

                        if(integerValue % 5 == 0){
                            request(5);
                        }
                    }
                });

    }
}
