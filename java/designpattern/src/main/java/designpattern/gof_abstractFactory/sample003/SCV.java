package designpattern.gof_abstractFactory.sample003;

public class SCV {

    public static BuilingConstructor createBuildingOrNull(String buildType) {
        switch (buildType) {
            case "barrack":
                return new Barrack();
            case "factory":
                return new Factory();
            default:
                return null;
        }
    }
}
