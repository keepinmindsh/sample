package designpattern.gof_command.sample02;

public class LampOnCommand implements Command {

    private Lamp theLamp;

    public LampOnCommand(Lamp lamp){
        this.theLamp = lamp;
    }

    @Override
    public void execute() {
        theLamp.turnOn();

        theLamp.checkLight();
    }
}
