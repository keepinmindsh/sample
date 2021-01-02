package lines.comm.handler;

import lines.comm.callback.ErrorCallback;
import lines.comm.callback.SuccessCallback;
import lines.comm.command.Command;
import lines.comm.provider.LinesProvider;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public class MessageHandler {


    private final Command command;
    private final Object parameter;
    private final SuccessCallback successCallback;
    private final ErrorCallback errorCallback;
    private final LinesProvider linesProvider;

    public Object execute(){
        Object result;
        try {

            // Provider
            command.setProvider(linesProvider);

            // Command 실행
            command.execute();

            // Command 결과값 반환 처리
            result = command.resultData();
        }catch (Exception exception){
            errorCallback.process(exception, command);

            return command.resultData();
        }

        successCallback.process(result);

        return result;
    }
}
