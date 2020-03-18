package designpattern.gof_command.sample02;

public class Button {

    private Command theCommand;

    public Button(Command command ){
        SetCommand(command);
    }

    public void SetCommand(Command command){
        this.theCommand = command;
    }

    public void pressed(){
        theCommand.execute();
    }
}
