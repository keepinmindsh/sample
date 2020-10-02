package lines.comm.handler;

import lines.comm.callback.ErrorCallback;
import lines.comm.callback.SuccessCallback;
import lines.comm.command.Command;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public class MessageHandler {


    private final Command command;
    private final Object parameter;
    private final BiFunction<Command, Object, Object> process;
    private final SuccessCallback successCallback;
    private final ErrorCallback errorCallback;

    public Object execute(){
        Object result;
        try {
            result = process.apply(command, parameter);
        }catch (Exception exception){
            errorCallback.process(exception, command);

            return command.resultData();
        }

        successCallback.process(result);

        return result;
    }
}
