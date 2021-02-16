package com.lines.credit.command.operation.van.vantype.kicc.approval.factory;

import com.lines.credit.model.Approval;
import com.lines.credit.command.operation.van.vantype.kicc.approval.type.CardApproval;
import com.lines.credit.command.operation.van.vantype.kicc.approval.type.CardCancelApproval;

public class KICCApprovalFactory {

    public com.lines.comm.inf.Approval getApproval(Approval approval){
        switch (approval.getApprovalType()){
            case CARD_APPROVAL:
                return new CardApproval();
            case CARD_CANCEL_APPROVAL:
                return new CardCancelApproval();
            default:
                return null;
        }

    }
}
