package designpattern.gof_templateMethod.sample04.template;

public abstract class Transfer implements Runnable {

    public void transfer(){

        clickTransfer();

        transferAtoB();

        reduceTransferAmountFromA();

        successTransferToB();

        clickTransfer();

        updateAccountOfB();

    }

    public abstract  int clickTransfer();
    public abstract  int transferAtoB();
    public abstract  int reduceTransferAmountFromA();
    public abstract  int successTransferToB();
    public abstract  int updateAccountOfB();
}
