package com.lines.digger.command;

import com.lines.digger.code.OperationCode;
import com.lines.digger.command.operation.*;
import com.lines.lib.command.Command;
import com.lines.lib.operation.Operate;
import com.lines.lib.operation.empty.EmptyOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

// TODO Log Command 적용 - 파일을 읽어오는 역할을 하는 서비스 적용
@RequiredArgsConstructor
@Slf4j
public class LogCommand implements Command<Object> {

    private final OperationCode operationCode;
    private final ServerRequest serverRequest;
    private Object result;

    @Override
    public void execute() throws Exception {

        Operate<Mono<Object>> operate = null;

        switch (operationCode){
            case FILE_OPEN:
            	log.info("File Open!");
        		operate = new FileOpen(serverRequest);
                log.info(String.format("Result : %s", operate.operate()));
                //log.info("File Open!");

                break;
            case FILE_TREE:
            	log.info("File Tree!");
            	try {
            		operate = new FileTree(serverRequest);        		
            		log.info(String.format("Result : %s", operate.operate()));
				} catch (Exception e) {
					log.error(String.format("File Tree Exception : %s", e.getMessage()));
				}
                break;
            case FILE_DOWNLOAD :
                operate = new FileDownload(serverRequest);

                log.info("File Download!");
                break;
            case FILE_ANALYZE:
                operate = new FileAnalyze(serverRequest);

                log.info("File Analyze!");
                break;
            case FILE_LIST :
            	log.info("File Lists");
            	try {
            		operate = new FileLists(serverRequest);
            		log.info(String.format("Result : %s", operate.operate()));			
				} catch (Exception e) {
					log.error(String.format("File List Exception : %s", e.getMessage()));
				}
                
                break;
            default:
                operate = new EmptyOperation();
                break;
        }

        this.result = operate.operate();

        log.info("Result: {}" , this.result);
    }

    @Override
    public Object result() {
        return this.result;
    }
}
