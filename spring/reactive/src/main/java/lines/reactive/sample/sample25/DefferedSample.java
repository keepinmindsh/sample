package lines.reactive.sample.sample25;

import lines.reactive.sample.sample23.ReactiveWebApplication;
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
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedDeque;


@SpringBootApplication
@Slf4j
@EnableAsync
public class DefferedSample {

    @RestController
    public static class MyController {


        Queue<DeferredResult<String>> queue = new ConcurrentLinkedDeque<>();

        @GetMapping("/async")
        public DeferredResult<String> async() throws Exception {
            log.info("dr");

            DeferredResult<String> deferredResult = new DeferredResult<>(600000L);

            queue.add(deferredResult);

            return deferredResult;
        }


        @GetMapping("/dr/count")
        public String drcount(){
            return String.valueOf(queue.size());
        }

        @GetMapping("/dr/event")
        public String drevent(String msg){
            for(DeferredResult<String> dr : queue){
                dr.setResult("Hello" + msg);

                queue.remove();
            }
            return "OK";
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
        SpringApplication.run(ReactiveWebApplication.class);
    }
}
