package com.lines.credit.command.operation.van.factory;

import com.lines.credit.code.VanType;
import com.lines.credit.command.operation.van.vantype.kicc.KICC;
import com.lines.credit.command.operation.van.vantype.Van;

public class ApprovalFactory {

    public static Van getVendorForApproval(VanType vanType){

        switch (vanType){
            default:
                return new KICC();
        }

    }
}
