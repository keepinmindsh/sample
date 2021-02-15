package com.lines.credit.code;

public enum VanType {
    KICC(44);

    private final int vanCode;

    VanType(int vanCode){
        this.vanCode = vanCode;
    }
}
