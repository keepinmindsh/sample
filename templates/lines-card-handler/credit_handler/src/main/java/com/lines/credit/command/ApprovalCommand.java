package com.lines.credit.command;

import com.lines.comm.command.SimpleCommand;
import com.lines.credit.model.ApprovalVO;
import com.lines.credit.model.ApprovalResultVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApprovalCommand implements SimpleCommand<ApprovalResultVO> {

    private final ApprovalVO approvalVO;

    @Override
    public void execute() throws Exception {

        switch (approvalVO.getSpecType()){
            case APPROVAL:
            case APPROVAL_RESULT:
            case REPRINT:
            case NETWORK_INFO:
            case VB_EXIT:
                break;
        }
    }

    @Override
    public ApprovalResultVO result() {
        return null;
    }
}
