package designpattern.gof_state.sample02.state;

public class ColdState implements HealthState {
    @Override
    public void run() {
        System.out.println("감기에 걸려서 뛸 수 없습니다.");
    }

    @Override
    public void work() {
        System.out.println("감기에 걸려서 걸을 수 없습니다.");
    }

    @Override
    public void shit() {
        System.out.println("갈기에 걸려서 쉴 수 있습니다.");
    }
}
