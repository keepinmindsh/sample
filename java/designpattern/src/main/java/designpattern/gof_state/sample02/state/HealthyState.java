package designpattern.gof_state.sample02.state;

public class HealthyState implements HealthState {
    @Override
    public void run() {
        System.out.println("매우 건강해서 쉽게 뛸수 있습니다.");
    }

    @Override
    public void work() {
        System.out.println("매우 건강해서 쉽게 걸을 수 있습니다.");
    }

    @Override
    public void shit() {
        System.out.println("매우 건강해서 쉽게 걸을 수 있습니다.");
    }
}
