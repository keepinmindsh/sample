package lines;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import reactor.netty.http.server.HttpServer;

@SpringBootApplication
public class ReactiveQueueCommandApplication {

    @Bean
    public NettyReactiveWebServerFactory nettyReactiveWebServerFactory() {
        NettyReactiveWebServerFactory webServerFactory = new NettyReactiveWebServerFactory();
        webServerFactory.addServerCustomizers(new EventLoopNettyCustomizer());
        return webServerFactory;
    }

    private static class EventLoopNettyCustomizer implements NettyServerCustomizer {

        @Override
        public HttpServer apply(HttpServer httpServer) {
            EventLoopGroup parentGroup = new NioEventLoopGroup();
            EventLoopGroup childGroup = new NioEventLoopGroup();
            return httpServer.tcpConfiguration(tcpServer -> tcpServer
                    .bootstrap(serverBootstrap -> serverBootstrap
                            .group(parentGroup, childGroup)
                            .channel(NioServerSocketChannel.class)));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveQueueCommandApplication.class);
    }
}
