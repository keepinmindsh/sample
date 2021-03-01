package com.lines.redis.schedular;

import com.lines.redis.code.RedisType;
import com.lines.redis.model.LogVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

        log.info("Log End!");
    }

}
