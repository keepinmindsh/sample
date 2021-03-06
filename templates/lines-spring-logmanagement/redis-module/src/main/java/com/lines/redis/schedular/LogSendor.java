package com.lines.redis.schedular;

import com.lines.model.LogDataRQVO;
import com.lines.model.LogRQVO;
import com.lines.redis.code.RedisType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class LogSendor {

    private final RedisTemplate redisTemplate;

    @Scheduled(cron = "0/5 * * * * *")
    public void sendLog(){
        log.info("Log Start!");

        List<LogRQVO> logRQVOSet =  redisTemplate.opsForSet().pop(RedisType.LINES_REDIS_KEY.name(), 100);

        logRQVOSet.forEach(logVO -> {
            log.info("LogData : {}", logVO.getContent());
        });


        int size = logRQVOSet.size();

        if(size > 0){

            LogDataRQVO logDataRQVO = new LogDataRQVO();

            WebClient webClient = WebClient.create("http://localhost:9091");

            logDataRQVO.setLogRQVOList(logRQVOSet);

            Mono<String> stringMono = webClient.post()
                    .uri("/v1/log/analyze")

                    .body(Mono.just(logDataRQVO), LogDataRQVO.class)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(String.class);

            stringMono.subscribe(value -> {
                log.info("Value : {} ", value );
            });

        }

        log.info("Log End!");
    }

}
