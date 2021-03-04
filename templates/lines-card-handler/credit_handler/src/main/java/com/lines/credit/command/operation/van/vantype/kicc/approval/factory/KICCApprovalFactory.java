package com.lines.credit.command.operation.van.vantype.kicc.approval.factory;

import com.lines.credit.model.ApprovalVO;
import com.lines.credit.command.operation.van.vantype.kicc.approval.type.CardApproval;
import com.lines.credit.command.operation.van.vantype.kicc.approval.type.CardCancelApproval;

public class KICCApprovalFactory {

    public com.lines.comm.inf.Approval getApproval(ApprovalVO approvalVO){
        switch (approvalVO.getSpecType()){
            case CARD_APPROVAL:
                return new CardApproval();
            case CARD_CANCEL_APPROVAL:
                return new CardCancelApproval();
            default:
                return null;
        }

    }
}
