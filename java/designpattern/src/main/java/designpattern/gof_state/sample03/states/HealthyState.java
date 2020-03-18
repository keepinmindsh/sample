package designpattern.gof_state.sample03.states;

public class HealthyState implements State {
    @Override
    public void Walk() {
        System.out.println("건강해서 잘 걷는다.");
    }

    @Override
    public void Laydown() {
        System.out.println("건강해서 잘 드러눕는다.");
    }

    @Override
    public void Coding() {
        System.out.println("건강해서 코딩을 열심히 한다.");
    }

    @Override
    public void Run() {
        System.out.println("건강해서 잘 뛴다.");
    }
}


