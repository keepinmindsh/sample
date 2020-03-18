package designpattern.gof_state.sample02.state;

public class BrokenState implements HealthState {
    @Override
    public void run() {
        System.out.println("다리가 부러져 뛸 수 없습니다.");
    }

    @Override
    public void work() {
        System.out.println("다리가 부러져 느리게 걷습니다.");
    }

    @Override
    public void shit() {
        System.out.println("다리가 부러졌지만 앉는 건 괜찮습니다.");
    }
}
