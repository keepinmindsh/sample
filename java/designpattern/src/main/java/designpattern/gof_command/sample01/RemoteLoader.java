package designpattern.gof_command.sample01;

import designpattern.gof_command.sample01.command.LightOffCommand;
import designpattern.gof_command.sample01.command.LightOnCommand;
import designpattern.gof_command.sample01.product.Light;
import designpattern.gof_command.sample01.receiver.RemoteControl;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light();
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

    }
}
