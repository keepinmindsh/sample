package com.lines.serial.code;

public enum MessageType {

    STX("\u0002"),
    ETX("\u0003"),
    ACK("\u0006"),
    NAK("\u0015");

    public String getValue() {
        return value;
    }

    private final String value;

    private MessageType(String value){
        this.value = value;
    }
}
