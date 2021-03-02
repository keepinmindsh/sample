package com.lines.redis.schedular;

import com.lines.redis.code.RedisType;
import com.lines.redis.model.LogVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

@Component
@Slf4j
@RequiredArgsConstructor
public class LogSendor {

    private final RedisTemplate redisTemplate;

    @Scheduled(cron = "0 0/1 * * * *")
    public void sendLog(){
        log.info("Log Start!");

        List<LogVO> logVOSet =  redisTemplate.opsForSet().pop(RedisType.LINES_REDIS_KEY.name(), 100);

        logVOSet.forEach(logVO -> {
            log.info("LogData : {}", logVO.getContent());
        });


        int size = logVOSet.size();

        if(size > 0){
            WebClient webClient = WebClient.create("http://localhost:9091");


            Mono<String> stringMono = webClient.post()
                    .uri("/v1/log/analyze")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(Mono.just(logVOSet), String.class)
                    .retrieve()
                    .bodyToMono(String.class);

            stringMono.subscribe(value -> {
                log.info("Value : {} ", value );
            });

        }

        log.info("Log End!");
    }

}
