package lines.sample02.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ClientApplication {

    // TODO - https://medium.com/swlh/building-a-chat-application-with-angular-and-spring-rsocket-3cd8013f2f55 링크 정리 필요
    // TODO - https://github.com/benwilcock/spring-rsocket-demo 소켓 데모 처리
    // TODO - https://docs.spring.io/spring-framework/docs/5.3.8-SNAPSHOT/reference/pdf/rsocket.pdf

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .main(ClientApplication.class)
                .sources(ClientApplication.class)
                .profiles("client")
                .run(args);
    }
}
