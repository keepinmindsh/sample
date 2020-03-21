package lines.springeventlisteners.command.impl;

import lines.springeventlisteners.command.Command;

public class PrintCommand implements Command {

    @Override
    public void execute() {
        System.out.println("나는 출력된다. ");
    }
}
