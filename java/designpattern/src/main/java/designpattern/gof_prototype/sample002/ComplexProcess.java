package designpattern.gof_prototype.sample002;

import java.util.List;

public class ComplexProcess implements Cloneable {

    private final Process complexProcess;

    public ComplexProcess(Process complexProcess) {
        this.complexProcess = complexProcess;
    }

    public List<Object> getProcessResult() {
        return complexProcess.getResultOfComplexProcess();
    }

    public ComplexProcess getCloneProcess() throws CloneNotSupportedException {
        return (ComplexProcess) super.clone();
    }
}
