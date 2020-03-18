package designpattern.gof_pacade.sample01.JVMComponent;

import designpattern.gof_pacade.sample01.ClassLoadSubSystem;
import designpattern.gof_pacade.sample01.JVMComponent.builder.JVMComponent;

public class JavacLoader {

    public static void main(String[] args) {

        JVMComponent.Builder builder = new JVMComponent.Builder();


        builder.Heap(new Heap());
        builder.JavaThreads(new JavaThreads());
        builder.MethodArea(new MethodArea());
        builder.ProgramCounterRegisters(new ProgramCounterRegisters());
        builder.NativeInternalThreads(new NativeInternalThreads());

        ClassLoadSubSystem classLoadSubSystem = new ClassLoadSubSystem(builder.build());

        classLoadSubSystem.ControlVariables();

    }
}
