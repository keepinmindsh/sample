package lines.client;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.net.URI;
import java.time.Duration;

public class WebSocketClientTest {
    public static void main(String[] args) throws Exception {
//        SslContext sslContext = SslContextBuilder
//                .forClient()
//                .trustManager(InsecureTrustManagerFactory.INSTANCE)
//                .build();
//
//
//        HttpClient httpClient = HttpClient.create().secure(sslContextSpec -> { sslContextSpec.sslContext(sslContext); });
//
//        WebSocketClient webSocketClient = new ReactorNettyWebSocketClient(httpClient);

        WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(
                URI.create("ws://localhost:8080/event-emitter"),
                session -> session.send(
                        Mono.just(session.textMessage("event-spring-reactive-client-websocket")))
                        .thenMany(session.receive()
                                .map(WebSocketMessage::getPayloadAsText)
                                .log())
                        .then())
                .block(Duration.ofSeconds(10L));
    }
}
