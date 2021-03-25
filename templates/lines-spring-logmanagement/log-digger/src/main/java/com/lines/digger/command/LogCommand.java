package com.lines.digger.command;

import com.lines.digger.code.OperationCode;
import com.lines.digger.command.operation.FileAnalyze;
import com.lines.digger.command.operation.FileOpen;
import com.lines.digger.command.operation.FileTree;
import com.lines.lib.command.Command;
import com.lines.lib.operation.Operate;
import com.lines.lib.operation.empty.EmptyOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

// TODO Log Command 적용 - 파일을 읽어오는 역할을 하는 서비스 적용
@RequiredArgsConstructor
@Slf4j
public class LogCommand implements Command<Map> {

    private final OperationCode operationCode;
    private final ServerRequest serverRequest;
    private final Map result;

    Operate operate = null;

    @Override
    public void execute() {

        result.put("number", 1234);
        result.put("text", "webFlux");
        result.put("path", serverRequest.queryParam("path").get());

        switch (operationCode){
            case FILE_OPEN:
                operate = new FileOpen();

                log.info("File Open!");
                break;
            case FILE_TREE:
                operate = new FileTree();

                log.info("File Tree!");
                break;
            case FILE_ANALYZE:
                operate = new FileAnalyze();

                log.info("File Analyze!");
                break;
            default:
                operate = new EmptyOperation();
                break;
        }
    }

    @Override
    public Map result() {
        return this.result;
    }
}
