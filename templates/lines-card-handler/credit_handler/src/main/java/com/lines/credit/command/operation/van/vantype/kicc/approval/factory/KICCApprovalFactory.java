package com.lines.credit.command.operation.van.vantype.kicc.approval.factory;

import com.lines.comm.inf.Approval;
import com.lines.credit.builder.ApprovalBuilder;
import com.lines.credit.command.operation.van.vantype.kicc.approval.type.CardApproval;
import com.lines.credit.command.operation.van.vantype.kicc.approval.type.CardCancelApproval;

public class KICCApprovalFactory {

    public Approval getApproval(ApprovalBuilder approvalBuilder){
        switch (approvalBuilder.getApprovalType()){
            case CARD_APPROVAL:
                return new CardApproval();
            case CARD_CANCEL_APPROVAL:
                return new CardCancelApproval();
            default:
                return null;
        }

    }
}
