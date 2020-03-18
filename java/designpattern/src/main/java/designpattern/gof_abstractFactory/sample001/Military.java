package designpattern.gof_abstractFactory.sample001;

public class Military {

    public static void main(String[] args) {


        TrainingFactory infantryFactory = TrainingProvider.getFactory("infantry");

        Soldier marine = infantryFactory.create("marine");

        marine.attack();
        marine.getSoldier();

        Soldier firbat = infantryFactory.create("fire");

        firbat.getSoldier();
        firbat.attack();
    }
}
