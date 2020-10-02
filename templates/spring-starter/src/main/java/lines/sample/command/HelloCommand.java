package lines.sample.command;

import lines.comm.command.Command;
import lines.sample.model.HelloWorldRQVO;

public class HelloCommand implements Command<HelloWorldRQVO, String> {

    private String result;


    @Override
    public void setProvider() {

    }

    @Override
    public void execute(HelloWorldRQVO parameter) {
        this.result = parameter.getMessage() + "From JSH";
    }

    @Override
    public Object userStatus() {
        return null;
    }

    @Override
    public String resultData() {
        return result;
    }
}
