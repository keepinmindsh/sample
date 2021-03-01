package com.lines.redis.messages;

import com.lines.redis.code.RedisType;
import com.lines.redis.model.LogVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class LogSave {

    private final RedisTemplate redisTemplate;

    @GetMapping("/log")
    public Object saveLog(String content){

        SetOperations<String, LogVO> setOperations = redisTemplate.opsForSet();

        LogVO logVO = new LogVO();

        logVO.setContent(content);

        setOperations.add(RedisType.LINES_REDIS_KEY.name(), logVO);

        return "success!";
    }

//    @GetMapping("/log")
//    public Object getLog(){
//        return redisTemplate.opsForSet().pop("LINES:LOGS:TEST");
//    }
}
