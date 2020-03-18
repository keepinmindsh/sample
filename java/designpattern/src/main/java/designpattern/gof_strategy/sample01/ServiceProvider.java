package designpattern.gof_strategy.sample01;

public class ServiceProvider {
    public static void main(String[] args) {
        Strategy strategy = null;
        Solider rambo = new Solider();
        strategy = new StrategyGun();

        rambo.runContext(strategy);

        System.out.println("\n");
        strategy = new StrategyGrenade();

        rambo.runContext(strategy);
    }
}
