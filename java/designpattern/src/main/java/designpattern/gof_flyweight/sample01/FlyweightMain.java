package designpattern.gof_flyweight.sample01;

public class FlyweightMain {

    private static INoodle[] ramen = new Ramen[20];
    private static NoodleContext[] tables = new NoodleContext[20];
    private static int ordersCount = 0;
    private static NoodleFactory noodleFactory;

    public static void takeOrder(String flavorIn, int table) {
        ramen[ordersCount] = noodleFactory.getNoodleFlavor(flavorIn);
        tables[ordersCount] = new NoodleContext(table);
        ordersCount++;
    }

    public static void main(String args[]) {
        noodleFactory = new NoodleFactory();

        takeOrder("Zin Ramen", 2);
        takeOrder("Zin Ramen", 2);
        takeOrder("Ahn Sung Tang Men", 1);
        takeOrder("Ahn Sung Tang Men", 2);
        takeOrder("Ahn Sung Tang Men", 3);
        takeOrder("Ahn Sung Tang Men", 4);
        takeOrder("Zin Ramen", 4);
        takeOrder("Zin Ramen", 5);
        takeOrder("Ahn Sung Tang Men", 3);
        takeOrder("Zin Ramen", 3);

        for (int i = 0; i < ordersCount; i++) {
            ramen[i].serveNoodle(tables[i]);
        }

        System.out.println("\n Total Coffee objects made: "
                + noodleFactory.getTotalNoodleFlavorMade());
    }
}
