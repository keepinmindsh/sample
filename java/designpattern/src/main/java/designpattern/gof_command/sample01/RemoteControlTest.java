package designpattern.gof_command.sample01;

import designpattern.gof_command.sample01.command.LightOnCommand;
import designpattern.gof_command.sample01.product.Light;
import designpattern.gof_command.sample01.receiver.SimpleRemoteControl;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();

        Light light = new Light();

        LightOnCommand lightOn = new LightOnCommand(light);

        remoteControl.setCommand(lightOn);
        remoteControl.buttonWasPressed();
    }
}
