package lines.comm.callback;

@FunctionalInterface
public interface SuccessCallback<ParamT, ReturnR>{
    public ReturnR process(ParamT paramT);
}
