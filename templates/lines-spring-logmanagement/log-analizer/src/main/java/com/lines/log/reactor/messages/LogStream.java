package com.lines.log.reactor.messages;

import com.lines.lib.command.Command;
import com.lines.log.reactor.command.AnalyzeCommand;
import com.lines.model.LogDataRQVO;
import com.lines.model.LogRQVO;
import com.lines.model.LogRSVO;
import lombok.extern.slf4j.Slf4j;
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
        List<LogRQVO> logRQVOList = logDataRQVO.getLogRQVOList();

        Flux.fromIterable(logRQVOList)
                .parallel()
                .log()
                .subscribe(logVO -> {

                    Command<LogRSVO> logCommand = new AnalyzeCommand(logVO);

                    logCommand.execute();

                    log.info("Log Data : {}" , logVO.getContent() );
                });

        log.info("analyze count : {}", logRQVOList.size());

        return "Success!";
    }

}
