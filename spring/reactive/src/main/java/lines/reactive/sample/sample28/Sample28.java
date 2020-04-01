package lines.reactive.sample.sample28;

import io.netty.channel.nio.NioEventLoopGroup;
import org.graalvm.compiler.lir.LIRInstruction;
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
import org.springframework.web.context.request.async.DeferredResult;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class Sample28 {

    // JMC

    @RestController
    public static class LinesController {

        //RestTemplate restTemplate = new RestTemplate();

        //AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();

        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory(new NioEventLoopGroup(1)));

        @GetMapping("/rest")
        public DeferredResult<String> rest(int idx){

            DeferredResult<String> deferredResult = new DeferredResult<>();


            ListenableFuture<ResponseEntity<String>> res1 = asyncRestTemplate.getForEntity("http://localhost:8081/service?req={req}", String.class,"Hello" + idx);

            res1.addCallback(
              s -> {
                deferredResult.setResult(s.getBody() + "/work");
              }
              , e -> {
                deferredResult.setErrorResult(e);
              });

            return deferredResult;
        }
    }

    public static void main(String[] args) {
        System.setProperty("server.tomcat.max-threads", "1");
        System.setProperty("server.port", "9090");
        SpringApplication.run(Sample28.class, args);
    }
}
