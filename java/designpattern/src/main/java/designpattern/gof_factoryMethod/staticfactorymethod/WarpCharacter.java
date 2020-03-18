package designpattern.gof_factoryMethod.staticfactorymethod;

public class WarpCharacter {
    public static Airship InterceptorWarp(Map mapObj, int xPostion, int yPostion) {
        return new Interceptor();
    }

    public static Airship ScouterWarp(Map mapObj, int xPostion, int yPostion) {
        return new Scouter();
    }

    public static Airship ArbiterWarp(Map mapObj, int xPostion, int yPostion) {
        return new Arbiter();
    }
}
