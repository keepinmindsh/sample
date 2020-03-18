package designpattern.gof_command.sample01.receiver;

import designpattern.gof_command.sample01.command.Command;

public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {

    };

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
