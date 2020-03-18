package designpattern.gof_abstractFactory.sample003;

public class Battle {
    public static void main(String[] args) {

        BuilingConstructor barrack1 = SCV.createBuildingOrNull("barrack");

        Unit marine1 = barrack1.createUnitOrNull("marine");

        marine1.attack();

        marine1.depend();

        marine1.destroyed();
    }
}
