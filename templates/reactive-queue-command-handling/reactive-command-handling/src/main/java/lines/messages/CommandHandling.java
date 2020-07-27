package lines.messages;


import lines.command.RequestAddCommand;
import lines.command.inf.Command;
import lines.model.RequestVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandHandling {

    @PostMapping("/request/command")
    public Object requestCommand(@RequestBody RequestVO requestVO){

        Command command = new RequestAddCommand(requestVO);

        return command.execute();
    }
}
