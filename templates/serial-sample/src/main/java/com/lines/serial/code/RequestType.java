package com.lines.serial.code;

public enum RequestType {
    Version(1),
    TransType(2),
    TransAmount(12),
    OtherAmount(12),
    PAN(19),
    ExpiryDate(4),
    CancelReason(2),
    InvoiceNumber(6),
    AuthorizationIDResponse(6),
    InstallmentFlag(1),
    RedeemFlag(1),
    DCCFlag(1),
    InstallmentPlan(3),
    InstallmentTenor(2),
    GenericData(12),
    ReffNumber(12),
    Filler(54);

    public int getValue() {
        return value;
    }

    private final int value;

    private RequestType(int value){
        this.value = value;
    }
}
