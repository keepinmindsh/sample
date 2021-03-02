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

@RestController
@RequestMapping("/v1")
@Slf4j
public class LogStream {

    @PostMapping("/log/analyze")
    public Object logAnalyze(@RequestBody LogDataRQVO logDataRQVO) {

        Flux.fromIterable(logDataRQVO.getLogVOList())
                .log()
                .subscribe(logVO -> {
                    log.info("Log Data : {}" , logVO.getContent() );
                });

        return "Success!";
    }

}
