package designpattern.gof_prototype.sample001;

public class Battle {

    public static void main(String[] args) {

        Unit prove1 = Nexus.createProve();

        prove1.Harvest();
        prove1.Harvest();
        prove1.Harvest();

        Arbiter arbiter1 = new Arbiter();

        Unit prove2 = arbiter1.copyRealUnit(prove1);

        System.out.println("prove 1 == prove 2  :" + (prove1 == prove2));

        System.out.println(prove1.getMineralCapacity());

        System.out.println(prove2.getMineralCapacity());

    }
}
