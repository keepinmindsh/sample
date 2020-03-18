package designpattern.gof_pacade.sample01.JVMComponent.builder;

import designpattern.gof_pacade.sample01.JVMComponent.Element.JVMElement;
import designpattern.gof_pacade.sample01.JVMComponent.*;

public class JVMComponent {

    private final Heap heap;
    private final JavaThreads javaThreads;
    private final MethodArea methodArea;
    private final NativeInternalThreads nativeInternalThreads;
    private final ProgramCounterRegisters programCounterRegisters;

    public static class Builder {

        private Heap heap;
        private JavaThreads javaThreads;
        private MethodArea methodArea;
        private NativeInternalThreads nativeInternalThreads;
        private ProgramCounterRegisters programCounterRegisters;

        public Builder Heap(Heap heap) {
            this.heap = heap;
            return this;
        }

        public Builder JavaThreads(JavaThreads javaThreads) {
            this.javaThreads = javaThreads;
            return this;
        }

        public Builder MethodArea(MethodArea methodArea) {
            this.methodArea = methodArea;
            return this;
        }

        public Builder NativeInternalThreads(NativeInternalThreads nativeInternalThreads) {
            this.nativeInternalThreads = nativeInternalThreads;
            return this;
        }

        public Builder ProgramCounterRegisters(ProgramCounterRegisters programCounterRegisters) {
            this.programCounterRegisters = programCounterRegisters;
            return this;

        }


        public JVMComponent build() {
            return new JVMComponent(this);
        }

    }

    private JVMComponent(Builder build) {
        this.heap = build.heap;
        this.javaThreads = build.javaThreads;
        this.methodArea = build.methodArea;
        this.nativeInternalThreads = build.nativeInternalThreads;
        this.programCounterRegisters = build.programCounterRegisters;
    }

    public JVMElement getJVMCompoentOrNull(String type) {
        switch (type) {
            case "Heap":
                return heap;
            case "JavaThreads":
                return javaThreads;
            case "MethodArea":
                return methodArea;
            case "NativeInternalThreads":
                return nativeInternalThreads;
            case "ProgramCounterRegisters":
                return programCounterRegisters;
        }

        return null;
    }
}
