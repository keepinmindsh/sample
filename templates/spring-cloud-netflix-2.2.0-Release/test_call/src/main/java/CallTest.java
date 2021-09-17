import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class CallTest {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(1000);

    public static void main(String[] args) {

        AtomicInteger atomicIntegerForError =new AtomicInteger();
        AtomicInteger atomicIntegerForSuccess = new AtomicInteger();


        List<Future> futureList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {

            futureList.add(executorService.submit(() -> {
                try{

                    RestTemplate restTemplate = new RestTemplate();
                    String result = restTemplate.getForObject("http://localhost:8762/business-api/call_test", String.class);
                    atomicIntegerForSuccess.incrementAndGet();
              //      log.info("result : {}", result);
                }catch (Exception exception){
                    atomicIntegerForError.incrementAndGet();

                }

            }));
            
        }

        futureList.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (ExecutionException exception) {
                exception.printStackTrace();
            }
        });

        if(!executorService.isShutdown()){
            executorService.shutdown();

            log.error("Success : count - {}", atomicIntegerForSuccess.incrementAndGet());
            log.error("Error : count - {}", atomicIntegerForError.incrementAndGet());
        }
    }
}
