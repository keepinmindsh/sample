package com.lines.credit.command;

import com.lines.comm.command.SimpleCommand;
import com.lines.credit.model.AlertVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlertCommand implements SimpleCommand {

    private final AlertVO alertVO;

    @Override
    public void execute() throws Exception {

    }

    @Override
    public Object result() {
        return null;
    }
}
