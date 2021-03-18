package com.lines.digger.command;

import com.lines.digger.code.OperationCode;
import com.lines.lib.command.Command;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// TODO Log Command 적용 - 파일을 읽어오는 역할을 하는 서비스 적용
@RequiredArgsConstructor
@Slf4j
public class LogCommand implements Command {

    private final OperationCode operationCode;

    @Override
    public void execute() {
        switch (operationCode){
            case FILE_OPEN:
                log.info("File Open!");
                break;
            case FILE_TREE:
                log.info("File Tree!");
                break;
            case FILE_ANALYZE:
                log.info("File Analyze!");
                break;
            case RESERVATION_GET:
                log.info("Reservation Get!");
                break;
            case RESERVATION_KEEP:
                log.info("Reservation Keep!");
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
