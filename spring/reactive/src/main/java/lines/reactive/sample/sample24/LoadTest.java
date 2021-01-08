package lines.reactive.sample.sample24;

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

        String url = "http://localhost:8080/callable";

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                int idx = atomicInteger.addAndGet(1);
                log.info("Thread" + idx);

                StopWatch stopWatch1 = new StopWatch();

                stopWatch1.start();

                restTemplate.getForObject(url, String.class);

                stopWatch1.stop();
                log.info("Elapsed : " + idx + " -> " + stopWatch.getTotalTimeSeconds());
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);

        stopWatch.stop();
        log.info("Total : {}" + stopWatch.getTotalTimeSeconds());
    }
}
