package designpattern.gof_templateMethod.sample04.template;

public class Push implements Action {

    private Transfer transfer;

    public Push(Transfer transfer){
        this.transfer = transfer;
    }

    @Override
    public void execute() {
        new Thread(transfer);
    }
}
