package lines.reactive.sample.sample26;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.concurrent.Executors;

@SpringBootApplication
@Slf4j
@EnableAsync
public class EmitterSample {

    @RestController
    public static class MyController {
        @GetMapping("/emitter")
        public ResponseBodyEmitter async() throws Exception {

            ResponseBodyEmitter responseBodyEmitter = new ResponseBodyEmitter();

            Executors.newSingleThreadExecutor().submit(() -> {
                for (int i = 0; i < 50; i++) {
                    try {
                        responseBodyEmitter.send("<p>Stream " + i + "</p>");
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            return responseBodyEmitter;
        }
    }

    @Component
    public static class MyService {

        @Async
        public ListenableFuture<String> hello() throws InterruptedException {
            log.info("hello()");
            Thread.sleep(2000);
            return new AsyncResult<>("Hello");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(EmitterSample.class);
    }
}
