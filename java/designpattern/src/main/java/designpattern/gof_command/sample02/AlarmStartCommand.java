package designpattern.gof_command.sample02;

public class AlarmStartCommand implements Command {

    private Alarm theAlarm;

    public AlarmStartCommand(Alarm alarm){
        this.theAlarm = alarm;
    }

    @Override
    public void execute() {
        theAlarm.start();
    }
}
