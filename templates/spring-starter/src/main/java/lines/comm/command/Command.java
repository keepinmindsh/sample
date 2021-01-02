package lines.comm.command;

import lines.comm.provider.LinesProvider;

public interface Command<paramT, returnR> {

    public void setProvider(LinesProvider linesProvider);

    public void execute();

    public Object userStatus();

    public returnR resultData();
}

