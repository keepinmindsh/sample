package designpattern.gof_bridge.sample_03.implement;

public class ConcreteAWork implements Implementor {
    @Override
    public void doAProcess() {
        System.out.println("A Work를 위한 A Process를 실행합니다.");
    }

    @Override
    public void doBProcess() {
        System.out.println("A Work를 위한 B Process를 실행합니다.");
    }
}
