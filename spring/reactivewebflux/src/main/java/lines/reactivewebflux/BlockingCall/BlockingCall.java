package lines.reactivewebflux.BlockingCall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.StopWatch;


@Slf4j
public class BlockingCall {
    public static void main(String[] args) {

        final RestTemplate restTemplate = new RestTemplate();

        final StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        for (int i = 0; i < 3; i++) {
            final ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:1000/helloWithThreeSeconds", HttpMethod.GET, HttpEntity.EMPTY, String.class);
        }

        stopWatch.stop();

        log.info("Time : {}", stopWatch.getTotalTimeSeconds());
    }
}
