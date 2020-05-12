package lines.reactivewebflux.sample05;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/*
    Schedulers.computation() - 이벤트 룹에서 간단한 연산이나 콜백 처리를 위해서 쓰는 것입니다. I/O 처리를 여기에서 해서는 안됩니다.
    Schedulers.from(executor) - 특정 executor를 스케쥴러로 사용합니다.
    Schedulers.immediate() - 현재 스레드에서 즉시 수행합니다.
    Schedulers.io() - 동기 I/O를 별도로 처리시켜 비동기 효율을 얻기 위한 스케줄러입니다. 자체적인 스레드 풀에 의존합니다.
    Schedulers.newThread() - 항상 새로운 스레드를 만드는 스케쥴러입니다.
    Schedulers.trampoline() - 큐에 있는 일이 끝나면 이어서 현재 스레드에서 수행하는 스케쥴러.
 */

@Slf4j
public class ConcurrencySample {
    public static void main(String[] args) throws InterruptedException {

        List<Object> integerList = new ArrayList<>();

        CountDownLatch latch = new CountDownLatch(1);

        Flux.just(1,2,3,4)
                .subscribeOn(Schedulers.newElastic("SUB"))
                .map(i -> i * 2)
                .log()
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {

                        log.info("Added Value : {}", value);

                        integerList.add(value);

                        request(1);
                    }

                    @Override
                    protected void hookOnComplete() {
                        log.info("hookOnComplete"); // SUB 쓰레드

                        latch.countDown();
                    }
                });

        latch.await();

        integerList.forEach(item -> {
            log.info("Item Value : {}", item);
        });
    }
}
