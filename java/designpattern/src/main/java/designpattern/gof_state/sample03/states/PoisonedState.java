package designpattern.gof_state.sample03.states;

public class PoisonedState implements State {
    @Override
    public void Walk() {
        System.out.println("독에 중독되어서 걸으면서 독을 퍼뜨린다.");
    }

    @Override
    public void Laydown() {
        System.out.println("독에 중독되어서 누어 있어야 한다.");
    }

    @Override
    public void Coding() {
        System.out.println("독에 중독되었지만 일정이 빠듯해 코딩을 한다.");
    }

    @Override
    public void Run() {
        System.out.println("독에 중독되었지만 달릴 수 있다.");
    }
}

