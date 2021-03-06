package com.lines.redis.messages;

import com.lines.model.LogRQVO;
import com.lines.redis.code.RedisType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class LogSave {

    private final RedisTemplate redisTemplate;

    @PostMapping("/log")
    public Object saveLog(@RequestBody LogRQVO logRQVO){

        SetOperations<String, LogRQVO> setOperations = redisTemplate.opsForSet();

        setOperations.add(RedisType.LINES_REDIS_KEY.name(), logRQVO);

        return "success!";
    }
}
