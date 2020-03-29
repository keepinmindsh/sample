package lines.reactive.sample.sample23;

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

import java.util.concurrent.Callable;

/*
* 비동기 서블릿 - Servlet 3.0
*
* 논블로킹 I/O - Servlet 3.1
*
* HttpServletRequest / HttpServletResponse - 블록킹 IO - inputStream와 outputStream에 의한
*     서블릿은 기본적으로 블로킹 IO 방식이다.
*
*
*
* */


@SpringBootApplication
@Slf4j
@EnableAsync
public class ReactiveWebApplication {

    @RestController
    public static class MyController {
        @GetMapping("/async")
        public Callable<String> async() throws Exception {
            log.info("callable");

            return () -> {

                log.info("async");

                Thread.sleep(2000);

                return "Hello";
            };
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
