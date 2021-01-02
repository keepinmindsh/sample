package lines.sample.command.hello;

import lines.comm.operation.Operation;
import lines.sample.model.HelloWorldRQVO;
import lines.sample.model.HelloWorldRSVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Search implements Operation<HelloWorldRSVO> {

    private final HelloWorldRQVO helloWorldRQVO;

    @Override
    public HelloWorldRSVO operate() {

        HelloWorldRSVO helloWorldRSVO = new HelloWorldRSVO();

        helloWorldRSVO.setMessage(helloWorldRQVO.getMessage()+ "From JSH");

        return helloWorldRSVO;
    }
}
