package designpattern.gof_strategy.sample01;

public class Solider {
    void runContext(Strategy strategy){
        System.out.println("배틀 그라운드 시작");
        strategy.runStrategy();
        System.out.println("배틀 종료 ");
    }
}
