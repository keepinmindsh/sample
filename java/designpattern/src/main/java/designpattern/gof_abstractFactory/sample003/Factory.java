package designpattern.gof_abstractFactory.sample003;

public class Factory implements BuilingConstructor {
    public Unit createUnitOrNull(String unitType) {
        switch (unitType) {
            case "siegetank":
                return new SiegeTank();
            default:
                return null;
        }
    }
}
