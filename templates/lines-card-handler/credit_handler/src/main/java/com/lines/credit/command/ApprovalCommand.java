package com.lines.credit.command;

import com.lines.comm.command.SimpleCommand;
import com.lines.credit.model.Approval;
import com.lines.credit.model.ApprovalResultVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApprovalCommand implements SimpleCommand<ApprovalResultVO> {

    private final Approval approval;

    @Override
    public void execute() throws Exception {

    }

    @Override
    public ApprovalResultVO result() {
        return null;
    }
}