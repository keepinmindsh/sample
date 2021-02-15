package com.lines.credit.code;

public enum ApprovalType {
    CARD_APPROVAL("CARD_APPROVAL"),
    CARD_CANCEL_APPROVAL("CARD_CANCEL_APPROVAL");

    private final String approvalType;

    ApprovalType(String approvalType){
        this.approvalType = approvalType;
    }
}
