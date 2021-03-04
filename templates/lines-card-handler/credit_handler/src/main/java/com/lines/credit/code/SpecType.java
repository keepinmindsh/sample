package com.lines.credit.code;

public enum SpecType {
    APPROVAL("CARD_APPROVAL"),
    APPROVAL_RESULT("CARD_CANCEL_APPROVAL"),
    VB_EXIT("VB_EXIT"),
    REPRINT("REPRINT"),
    NETWORK_INFO("NETWORK_INFO");

    private final String approvalType;

    SpecType(String approvalType){
        this.approvalType = approvalType;
    }
}
