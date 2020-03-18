package designpattern.gof_bridge.sample_03.abstractlogic;

public abstract class AbstractLogic {

    protected abstract void doAProcess();

    protected abstract void doBProcess();

    public void doAllProcess(){

        doAProcess();

        doBProcess();
    }
}
