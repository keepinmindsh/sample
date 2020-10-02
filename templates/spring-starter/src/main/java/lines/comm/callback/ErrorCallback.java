package lines.comm.callback;

import lines.comm.command.Command;

@FunctionalInterface
public interface ErrorCallback{
    public void process(Exception exception, Command command);
}
