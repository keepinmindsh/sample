package lines.webclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ControllerWithWebClient {

    @GetMapping("/hello/world")
    public String helloWorld(){

        WebClient webClient = WebClient.create("http://localhost:11900");

        String result = webClient
                            .get()
                            .uri(String.format("/getUser"))
                            .retrieve()
                            .bodyToMono(String.class).block();

        Mono<String> monoReulst = webClient
                                        .get()
                                        .uri(String.format("/get/user"))
                                        .retrieve()
                                        .bodyToMono(String.class);

        monoReulst.subscribe(
                consumer -> {
                    consumer.getBytes();
                }
        );

        return result;
    }
}
