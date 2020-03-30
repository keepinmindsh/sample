package lines.reactive.sample.sample27;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class Sample27 {

    // JMC

    @RestController
    public static class LinesController {

        //RestTemplate restTemplate = new RestTemplate();

        //AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();

        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory(new NioEventLoopGroup(1)));

        @GetMapping("/rest")
        public ListenableFuture<ResponseEntity<String>> rest(int idx){

            // 1단계
            // GetForObject는 Blocking Method
            // API 를 호출하는 이작업을 비동기적으로 처리하고 싶음.
            //String res = restTemplate.getForObject("http://localhost:8081/service?req={req}", String.class,"Hello" + idx);

            // 2단계
            // Listenable Future
            // 컨트롤러가 반환을 하면 호출자체를 비동기적으로 처리하기 때문에 스프링이 콜백을 자동으로 등록을 하고, 내부적으로 처리한다.
            // NonBlocking 구조로 어떻게 동작하느냐 ?
            // 톰캣 스레드는 하나로 운영되지만 해당 요청이 호출되었을때, 비동기로 하는 것 맞지만, 백그라운드에서 스레드를 만들어서 처리한다. 기본적인 자바의 네크워크 API 를 호출하는 코드가 된다.
            // ListenableFuture<ResponseEntity<String>> res1 = asyncRestTemplate.getForEntity("http://localhost:8081/service?req={req}", String.class,"Hello" + idx);

            // 3 단계
            // Netty를 이용한 호출 방식
            // Netty에 의해서 외부 호출을 처리하는 스레드 그룹이 별도로 만들어짐. -
            ListenableFuture<ResponseEntity<String>> res1 = asyncRestTemplate.getForEntity("http://localhost:8081/service?req={req}", String.class,"Hello" + idx);

            return res1;
        }
    }

    public static void main(String[] args) {
        System.setProperty("server.tomcat.max-threads", "1");
        SpringApplication.run(Sample27.class, args);
    }
}
