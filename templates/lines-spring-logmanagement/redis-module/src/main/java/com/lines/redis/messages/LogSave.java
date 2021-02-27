package com.lines.redis.messages;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class LogSave {

    private final RedisTemplate redisTemplate;

    @PostMapping("/log")
    public Object saveLog(){

        SetOperations<String, String> setOperations = redisTemplate.opsForSet();

        setOperations.add("123123", "123123");

        return null;
    }
}
