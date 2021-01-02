package lines.sample.messages;

import lines.comm.handler.MessageHandler;
import lines.comm.provider.LinesProvider;
import lines.sample.command.HelloCommand;
import lines.sample.model.HelloWorldRQVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1")
public class HelloWorld {

    @GetMapping("/hello")
    public Object helloWorld(HelloWorldRQVO helloWorldRQVO){

        MessageHandler messageHandler = new MessageHandler(
                                    new HelloCommand(),
                                    helloWorldRQVO,
                                    ( exception) -> null,
                                    ( exception, command) -> {
                                        log.error(exception.getMessage());
                                    },
                                    LinesProvider.builder()
                                            .paramT(helloWorldRQVO)
                                            .build());

        return messageHandler.execute();
    }
}
