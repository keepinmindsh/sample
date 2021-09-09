import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class CallTest {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(1000);

    public static void main(String[] args) {

        AtomicInteger atomicInteger =new AtomicInteger();

        for (int i = 0; i < 1000; i++) {

            executorService.submit(() -> {
                try{
                    RestTemplate restTemplate = new RestTemplate();

                    String result = restTemplate.getForObject("http://localhost:8762/business-api/call_test", String.class);

                    log.info("result : {}", result);
                }catch (Exception exception){
                    log.error("Error : count - {}", atomicInteger.incrementAndGet());
                }

            });
            
        }
    }
}
