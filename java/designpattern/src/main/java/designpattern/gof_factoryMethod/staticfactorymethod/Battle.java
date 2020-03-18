package designpattern.gof_factoryMethod.staticfactorymethod;

public class Battle {

    public static void main(String[] args) {

        Map map = new Map();

        Airship arbiter1 = WarpCharacter.ArbiterWarp(map, 10, 60);

        Airship interceptor1 = WarpCharacter.InterceptorWarp(map, 60, 800);

        Airship scouter1 = WarpCharacter.ScouterWarp(map, 300, 1024);

        arbiter1.Attack();

        interceptor1.Attack();

        scouter1.Attack();
    }
}
