package lines.comm.command;

public interface Command<paramT, returnR> {

    public void setProvider();

    public void execute(paramT parameter);

    public Object userStatus();

    public returnR resultData();
}

