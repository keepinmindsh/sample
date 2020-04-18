package lines.reactive.sample.sample33;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@Slf4j
@EnableAsync
public class Sample33 {
    @RestController
    public static class LinesController {

        @Autowired MyService myService;

        WebClient client = WebClient.create();

        @GetMapping("/rest")
        public Mono<String> rest(int idx){

            // 이 상태 에서 정의 하는 것으로는 실행 되지 않음
            // 그이유는 Mono는 Publihser 상속하기 때문에 실제 구독이 되지 않으면 실행한다.
            // Async Template과 Deffered Result와 동일한 구조로 동작한다.
            // 비동기 Non Blocking 관점으로 동작한다.
            return  client.get().uri("http://localhost:8082/service?req={req}", idx).exchange()
                    .doOnNext(c ->  log.info(" After First " +c.toString()) )
                    .flatMap(clientResponse -> clientResponse.bodyToMono(String.class))
                    .flatMap((String res1) -> client.get().uri("http://localhost:8082/service2?req={req}", res1).exchange())
                    .flatMap(c -> c.bodyToMono(String.class))
                    .doOnNext(c ->  log.info(" After Second " +c.toString()) )
                    .flatMap(res2 -> Mono.fromCompletionStage(myService.work(res2)))
                    .doOnNext(c ->  log.info(" After fromCompletionStage " +c.toString()));

        }

/*
        @GetMapping("/rest")
        public Mono<String> rest(int idx){

            // 이 상태 에서 정의 하는 것으로는 실행 되지 않음
            // 그이유는 Mono는 Publihser 상속하기 때문에 실제 구독이 되지 않으면 실행한다.
            // Async Template과 Deffered Result와 동일한 구조로 동작한다.
            Mono<ClientResponse> clientResponseMono = client.get().uri("http://localhost:8082/service?req={req}", idx).exchange();

            Mono<String> body = clientResponseMono.flatMap(clientResponse -> clientResponse.bodyToMono(String.class));

            return body;

//            // 아래와 같이 구독이 실행 되어야 처리가 된다.
//            ClientResponse clientResponse =  null;
//            Mono<String> mono = clientResponse.bodyToMono(String.class);
//
//
//            return mono;
        }
 */


//        @GetMapping("/rest")
//        public Mono<String> rest(int idx){
//            /*
//                Mono, Flux
//                Mono - 데이터를 우리가 파라미터로 던지고 리턴 값을 결과를 담아 반환
//             */
//
//            String string = "Hello";
//
//            Mono<String> stringM = Mono.just("Hello");
//            return Mono.just("Hello");
//        }
    }

    @Service
    public static class MyService{
        @Async
        public CompletableFuture<String> work(String req){
            return CompletableFuture.completedFuture(req + "/Service");
        }
    }

    public static void main(String[] args) {
        System.setProperty("server.tomcat.max-threads", "1");
        System.setProperty("server.port", "9090");
        SpringApplication.run(Sample33.class, args);
    }
}
