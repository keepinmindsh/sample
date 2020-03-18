package designpattern.gof_bridge.sample_03;

import designpattern.gof_bridge.sample_03.abstractlogic.AbstractLogic;
import designpattern.gof_bridge.sample_03.abstractlogic.WorkProcess;
import designpattern.gof_bridge.sample_03.implement.ConcreteAWork;

public class Test {
    public static void main(String[] args) {

        AbstractLogic abstractLogic = new WorkProcess(new ConcreteAWork());

        abstractLogic.doAllProcess();

    }
}
