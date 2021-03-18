package com.lines.digger.command;

import com.lines.digger.code.OperationCode;
import com.lines.lib.command.Command;
import lombok.RequiredArgsConstructor;

// TODO Log Command 적용 - 파일을 읽어오는 역할을 하는 서비스 적용
@RequiredArgsConstructor
public class LogCommand implements Command {

    private final OperationCode operationCode;

    @Override
    public void execute() {
        switch (operationCode){
            case FILE_OPEN:
                break;
            case FILE_TREE:
                break;
            case FILE_ANALYZE:
                break;
            case RESERVATION_GET:
                break;
            case RESERVATION_KEEP:
                break;
            default:
                break;
        }
    }

    @Override
    public Object result() {
        return null;
    }
}
