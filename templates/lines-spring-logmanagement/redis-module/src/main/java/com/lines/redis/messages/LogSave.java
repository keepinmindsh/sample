package com.lines.redis.messages;

import com.lines.redis.code.RedisType;
import com.lines.redis.model.LogVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class LogSave {

    private final RedisTemplate redisTemplate;

    @PostMapping("/log")
    public Object saveLog(@RequestBody  String content){

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
