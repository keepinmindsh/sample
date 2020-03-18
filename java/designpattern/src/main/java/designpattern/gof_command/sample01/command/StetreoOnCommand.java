package designpattern.gof_command.sample01.command;

import designpattern.gof_command.sample01.product.Stereo;

public class StetreoOnCommand implements Command {

    Stereo stereo;

    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(50);
    }

    public void undo() {
        stereo.off();
    }
}
