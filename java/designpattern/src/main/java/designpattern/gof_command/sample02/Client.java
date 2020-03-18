package designpattern.gof_command.sample02;

public class Client {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Command lampOnCommand = new LampOnCommand(lamp);
        Alarm alarm = new Alarm();
        Command alarmOnCommand = new AlarmStartCommand(alarm);

        Button button1 = new Button(lampOnCommand);

        button1.pressed();

        Button button2 = new Button(alarmOnCommand);
        button2.pressed();
        button2.SetCommand(lampOnCommand);
        button2.pressed();
    }
}
