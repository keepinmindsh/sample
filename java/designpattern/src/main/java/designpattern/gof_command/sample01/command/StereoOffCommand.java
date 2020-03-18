package designpattern.gof_command.sample01.command;

import designpattern.gof_command.sample01.product.Stereo;

public class StereoOffCommand implements Command {

    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.off();
    }

    public void undo() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(50);
    }
}
