package lines.sample.command;

import lines.comm.command.Command;
import lines.comm.operation.Operation;
import lines.comm.provider.LinesProvider;
import lines.sample.command.hello.Search;
import lines.sample.model.HelloWorldRQVO;
import lines.sample.model.HelloWorldRSVO;

public class HelloCommand implements Command<HelloWorldRQVO, HelloWorldRSVO> {

    private HelloWorldRSVO result;
    private LinesProvider<HelloWorldRQVO> linesProvider;


    @Override
    public void setProvider(LinesProvider linesProvider) {
        this.linesProvider = linesProvider;
    }

    @Override
    public void execute() {
        HelloWorldRQVO helloWorldRQVO = linesProvider.getParamT();

        Operation<HelloWorldRSVO> operation = new Search(helloWorldRQVO);

        this.result = operation.operate();
    }

    @Override
    public Object userStatus() {
        return null;
    }

    @Override
    public HelloWorldRSVO resultData() {
        return result;
    }
}
