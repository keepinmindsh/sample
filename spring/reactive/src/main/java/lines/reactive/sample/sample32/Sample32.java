package lines.reactive.sample.sample32;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class Sample32 {
    @RestController
    public static class LinesController {

        @Autowired MyService myService;


        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory(new NioEventLoopGroup(1)));

        @GetMapping("/rest")
        public DeferredResult<String> rest(int idx){

            DeferredResult<String> deferredResult = new DeferredResult<>();

            // 예외를 처리하는 방식
            // 파라미터를 받는 방식은 Generic을 활용해서 어떤 종류의 타입을 전달하더라도 문제가 없게 만들 수 있다.
            // Generic에 의한 처리
//            Completion
//                    .from(asyncRestTemplate.getForEntity("http://localhost:8082/service?req={req}", String.class,"Hello" + idx))
//                    .andApply(s -> asyncRestTemplate.getForEntity("http://localhost:8082/service2?req={req}", String.class, s))
//                    .andApply(s -> myService.work(s.toString()))
//                    .andError(deferredResult::setErrorResult)
//                    .andAccept(deferredResult::setErrorResult);

           toCF(asyncRestTemplate.getForEntity("http://localhost:8082/service?req={req}", String.class, "Hello" + idx))
                   .thenCompose(s -> toCF(asyncRestTemplate.getForEntity("http://localhost:8082/service2?req={req}", String.class, s)))
                   .thenApplyAsync(s2 -> myService.work(s2.getBody()))
                   .thenAccept(s3 -> deferredResult.setResult(s3))
                   .exceptionally(e -> { deferredResult.setErrorResult(e.getMessage()); return (Void)null; } );

            return deferredResult;
        }

        <T> CompletableFuture<T> toCF(ListenableFuture<T> lf){
            CompletableFuture<T> cf = new CompletableFuture<T>();

            lf.addCallback(s -> cf.complete(s), e-> cf.completeExceptionally(e));

            return cf;
        }
    }


    @Service
    public static class MyService{
        public String work(String req){
            return req + "/Service";
        }
    }

    @Bean
    public ThreadPoolTaskExecutor myThreadPool(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        /*
           코어 갯수 스레드 갯수
           맥스 스레드 갯수

           코어가 다차면 큐를 채우기 시작하고 그리고 맥스 풀사이즈 까지 늘리는가?

           코어갯수가 다차면,  큐를 먼저 채우고, 맥스 풀 사이즈 까지 채우다가 그것까지 다차면 에러가 난다.

         */
        threadPoolTaskExecutor.setCorePoolSize(1);
        threadPoolTaskExecutor.setMaxPoolSize(1);

        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    public static void main(String[] args) {
        System.setProperty("server.tomcat.max-threads", "1");
        System.setProperty("server.port", "9090");
        SpringApplication.run(Sample32.class, args);
    }
}
