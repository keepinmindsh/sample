package com.lines.log.reactor.command;

import com.lines.lib.command.Command;
import com.lines.model.LogRQVO;
import com.lines.model.LogRSVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AnalyzeCommand implements Command<LogRSVO> {

    private final LogRQVO logRQVO;

    @Override
    public void execute() {

    }

    @Override
    public LogRSVO result() {
        return null;
    }
}
