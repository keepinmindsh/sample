package lines.reactive.sample.sample22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Configuration
@ComponentScan
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableAsync
public class SpringBootApplicationSample01 {

    @Component
    public static class MyService {
        // 해당 부분에서 대해서 Future를 사용하던, void를 사용하던 이는 업무 프로세스에 따라서 처리할 수 있다.
        // 장시간 처리 프로세스에 대해서 처리 방식
        //  스프링에서 제공하는 Listenable Future 를 이용하여 callback 방식으로 응답 처리
        @Async
        public ListenableFuture<String> hello() throws InterruptedException {
            Thread.sleep(2000);
            return new AsyncResult<>("Hello") ;
        }

//        @Async
//        public CompletableFuture<String> hello2() throws InterruptedException {
//            Thread.sleep(2000);
//            return new AsyncResult<>("Hello") ;
//        }
    }

    public static void main(String[] args) {
        try(ConfigurableApplicationContext c = SpringApplication.run(SpringBootApplicationSample01.class, args)){

        }
    }

    @Autowired MyService myService;

    @Bean
    ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(100);
        threadPoolTaskExecutor.setQueueCapacity(50);
        threadPoolTaskExecutor.setThreadNamePrefix("My Thread");


        return threadPoolTaskExecutor;
    }

    @Bean
    ApplicationRunner run(){
        return args -> {
            System.out.println("Run()");
            ListenableFuture<String>  future= myService.hello();

            future.addCallback( s -> System.out.println(s), e -> System.out.println(e.getMessage()));
            System.out.println("Exit");
        };
    }


}
