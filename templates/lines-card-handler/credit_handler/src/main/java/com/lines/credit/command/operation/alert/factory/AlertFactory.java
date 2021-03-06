package com.lines.credit.command.operation.alert.factory;

import com.lines.credit.command.operation.alert.type.*;
import com.lines.credit.model.AlertVO;

public class AlertFactory {
    public static AlertOperation getAlertOperation(AlertVO alertVO){
        switch (alertVO.getAlertType()){
            case READ:
                return new Read();
            case PROCESSING:
                return new Processing();
            case BROADCASTING:
                return new BroadCasting();
            case CLEARING:
                return new Clearing();
            default:
                return null;
        }
    }
}
