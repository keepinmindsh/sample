package designpattern.gof_flyweight.sample01;

public class NoodleContext {
    private final int tableNumber;

    public NoodleContext(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTable() {
        return this.tableNumber;
    }
}
