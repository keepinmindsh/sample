package lines.reactive.sample.sample32;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class LoadTest {

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:9090/rest?idx={idx}";

        //CyclicBarrier cyclicBarrier = new CyclicBarrier(101);

        for (int i = 0; i < 100; i++) {

            // Callable
            executorService.submit(() -> {   // Runnable은 Thread를 처리할 수 없다.
                int idx = atomicInteger.addAndGet(1);


                //cyclicBarrier.await();

                log.info("Thread {}", idx);

                StopWatch stopWatch1 = new StopWatch();

                stopWatch1.start();

                String res = restTemplate.getForObject(url, String.class, idx);

                stopWatch1.stop();

                log.info("Elapsed :  {} {} / {} " , idx , stopWatch1.getTotalTimeSeconds(), res);

                return null;
            });
        }

        //cyclicBarrier.await();

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);

        stopWatch.stop();

        log.info("Total : {}" + stopWatch.getTotalTimeSeconds());
    }
}
