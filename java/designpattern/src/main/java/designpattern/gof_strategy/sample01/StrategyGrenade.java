package designpattern.gof_strategy.sample01;

public class StrategyGrenade implements Strategy {
    @Override
    public void runStrategy() {
        System.out.println("수류탄 꽝꽝");
    }
}
