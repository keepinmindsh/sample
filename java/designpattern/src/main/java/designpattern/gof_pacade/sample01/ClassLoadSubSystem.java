package designpattern.gof_pacade.sample01;

import designpattern.gof_pacade.sample01.JVMComponent.Element.JVMElement;
import designpattern.gof_pacade.sample01.JVMComponent.builder.JVMComponent;

public class ClassLoadSubSystem {

    public JVMComponent jvmComponent;

    public ClassLoadSubSystem(JVMComponent jvmComponent) {
        this.jvmComponent = jvmComponent;
    }

    public void ControlVariables() {

        JVMElement methodArea = jvmComponent.getJVMCompoentOrNull("MethodArea");

        methodArea.doProcess();

    }
}
