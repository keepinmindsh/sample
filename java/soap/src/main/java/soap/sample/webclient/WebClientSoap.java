package soap.sample.webclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
public class WebClientSoap {
    public static void main(String[] args) {
        String _request = "            <SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:myNamespace=\"https://www.w3schools.com/xml/\">\n" +
                "                <SOAP-ENV:Header/>\n" +
                "                <SOAP-ENV:Body>\n" +
                "                    <myNamespace:CelsiusToFahrenheit>\n" +
                "                        <myNamespace:Celsius>100</myNamespace:Celsius>\n" +
                "                    </myNamespace:CelsiusToFahrenheit>\n" +
                "                </SOAP-ENV:Body>\n" +
                "            </SOAP-ENV:Envelope>";

        WebClient webClient = WebClient.builder().baseUrl("https://www.w3schools.com/xml/tempconvert.asmx").build();

        Mono<String> stringMono = webClient.post()
                .uri("https://www.w3schools.com/xml/tempconvert.asmx")
                .body(BodyInserters.fromValue(_request))
                .retrieve()
                .bodyToMono(String.class);

        stringMono.subscribe(log::debug);
    }
}

