package designpattern.gof_state.sample03.states;

public class LegBrokenState implements State {
    @Override
    public void Walk() {
        System.out.println("다리가 부러져서 더이상 걸을 수 없다.");
    }

    @Override
    public void Laydown() {
        System.out.println("다리가 부러졌지만 누울 수 있다.");
    }

    @Override
    public void Coding() {
        System.out.println("다리가 부러졌지만 손이 안부러져서 코딩은 할 수 있다.");
    }

    @Override
    public void Run() {
        System.out.println("다리가 부러져서 뛰지를 못한다.");
    }
}
