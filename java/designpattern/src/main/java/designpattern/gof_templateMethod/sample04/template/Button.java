package designpattern.gof_templateMethod.sample04.template;

public class Button implements Runnable {

    private Transfer transfer;

    public Button(Transfer ATM){
        this.transfer = ATM;
    }

    @Override
    public void run() {
        transfer.transfer();
    }
}
