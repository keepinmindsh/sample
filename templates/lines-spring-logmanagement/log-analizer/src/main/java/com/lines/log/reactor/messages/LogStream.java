package com.lines.log.reactor.messages;

import com.lines.log.reactor.model.LogDataRQVO;
import com.lines.log.reactor.model.LogVO;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Slf4j
public class LogStream {

    @PostMapping("/log/analyze")
    public Object logAnalyze(@RequestBody LogDataRQVO logDataRQVO) {

        List<LogVO> logVOList = logDataRQVO.getLogVOList();

        Flux.fromIterable(logVOList)
                .log()
                .subscribe(logVO -> {
                    log.info("Log Data : {}" , logVO.getContent() );
                });

        log.info("analyze count : {}", logVOList.size());

        return "Success!";
    }

}
