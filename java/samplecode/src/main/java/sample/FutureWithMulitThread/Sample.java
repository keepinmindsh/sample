package sample.FutureWithMulitThread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Sample {

    private final static ExecutorService executors = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        List<Future> futureList = new ArrayList<>();

        AtomicInteger atomicInteger = new AtomicInteger();

        for (int i = 0; i < 10; i++) {
            futureList.add(executors.submit(() -> {
                log.info("Result : {}", atomicInteger.incrementAndGet() + "값이 실행되었습니다.");
            }));
        }

        futureList.forEach(item -> {
            try {
                item.get();
            } catch (Exception exception) {
                log.error(exception.getMessage());
            }
        });
    }
}
