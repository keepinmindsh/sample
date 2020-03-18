package designpattern.gof_abstractFactory.sample003;

public class Barrack implements BuilingConstructor {
    public Unit createUnitOrNull(String unitType) {
        switch (unitType) {
            case "marine":
                return new Marine();
            case "firebat":
                return new FireBat();
            default:
                return null;
        }
    }
}
