package designpattern.gof_abstractFactory.sample003;

public class Starport implements BuilingConstructor {

    public Unit createUnitOrNull(String unitType) {
        switch (unitType) {
            case "wraith":
                return new Wraith();
            default:
                return null;
        }
    }
}
