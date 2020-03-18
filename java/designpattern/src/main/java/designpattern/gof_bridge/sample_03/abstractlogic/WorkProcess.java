package designpattern.gof_bridge.sample_03.abstractlogic;

import designpattern.gof_bridge.sample_03.implement.Implementor;

public class WorkProcess extends AbstractLogic {

    private Implementor implementor;

    public WorkProcess(Implementor implementor){
        this.implementor = implementor;
    }

    @Override
    protected void doAProcess() {
        implementor.doAProcess();
    }

    @Override
    protected void doBProcess() {
        implementor.doBProcess();
    }
}
