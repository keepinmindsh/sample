package lines.reactivewebflux.NonBlockingCall;

import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;

public class NonBlockingCall {
    public static void main(String[] args) {
        final StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        WebClient  webClient = WebClient.builder().build();

        for (int i = 0; i < 100; i++) {
           webClient
                    .get()
                    .uri("http://localhost:1000/helloWithThreeSeconds")
                    .retrieve()
                    .bodyToMono(String.class)
                    .subscribe(it -> {
                        System.out.println(it);
                    });
        }


        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
    }
}
