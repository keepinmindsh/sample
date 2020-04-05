package lines.reactive.sample.sample29;

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

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class Sample29 {

    // JMC

    @RestController
    public static class LinesController {

        //RestTemplate restTemplate = new RestTemplate();

        //AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();

        @Autowired MyService myService;


        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory(new NioEventLoopGroup(1)));

        // 서버 자원을 효율적으로 사용할 수 있는 기본 적인 예제 처리

        /*

            ListenableFuture를 이용하여 비동기적으로 스레드 하나만 사용하게 설정해서 처리하면 스레드 하나로 서버의 효율을 최대로 늘려서 사용할 수 있다.
            스레드로 인한 메모리의 부담은 최소화 된다.
            상당히 가벼운 오브젝트가 만들어지는 것은 전혀 문제가 되지 않음

            스레드 하나가지고 순차적으로 사용하기 때문에 처리하기 위한 불필요한 것을 많이 만들지 않는다.

            비동기 코드를 잘 사용하면 정말 효율적인 메모리 사용이 가능하다.
         */
        @GetMapping("/rest")
        public DeferredResult<String> rest(int idx){

            DeferredResult<String> deferredResult = new DeferredResult<>();

            ListenableFuture<ResponseEntity<String>> res1 = asyncRestTemplate.getForEntity("http://localhost:8082/service?req={req}", String.class,"Hello" + idx);

            // Callback Hell의 치명적인 구조
            // 전체 구조를 파악하기에 너무 어려운 구조
            // 동일한 작업을 계속적으로 진행하는 문제가 있음 ( DRY )

            // 스토리지 Access 하는 작업에 대해서는 기본적으로 JDBC를 사용하게 되어 있는데 기본적으로 모두 Blocking으로 되어 있어 Thread를 추가하는 비동기적인 것은 괜찮지만
            // Non Blocking IO를 이용하는 방식은 불가능하다.
            // 비동기 NonBlocking 드라이버 - 몽고 DB
            // DB는 블로킹이 걸린다. - 2017년 기준
            res1.addCallback(
              s -> {
                  ListenableFuture<ResponseEntity<String>> res2 = asyncRestTemplate.getForEntity("http://localhost:8082/service2?req={req}", String.class,"Hello" + idx);

                  res2.addCallback(s2 -> {
                      //deferredResult.setResult(s2.getBody() + "/work");

                      ListenableFuture<String> res3 = myService.work(s2.getBody());
                      res3.addCallback(s3 -> {
                          deferredResult.setResult(s3);
                      }, e3 -> {
                          deferredResult.setErrorResult(e3);
                      });
                  }, e2 -> {
                      deferredResult.setErrorResult(e2);
                  });
              }
              , e -> {
                deferredResult.setErrorResult(e);
              });

            return deferredResult;
        }
    }

    @Service
    public static class MyService{
        @Async
        public ListenableFuture<String> work(String req){
            return new AsyncResult<>(req + "/Service");
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
        SpringApplication.run(Sample29.class, args);
    }
}
