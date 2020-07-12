package lines.module.sample.router;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
public class HelloRouterTests {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://localhost:1000");

        Mono<ClientResponse> clientResponseMono = webClient.get()
                .uri("/hello")
                .accept(MediaType.TEXT_PLAIN)
                .exchange();

        log.info(">> Result = " + clientResponseMono.flatMap(res -> res.bodyToMono(String.class)).block() );
    }
}
