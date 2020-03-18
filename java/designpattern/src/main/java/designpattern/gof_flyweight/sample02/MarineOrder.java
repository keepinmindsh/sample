package designpattern.gof_flyweight.sample02;

public class MarineOrder implements Order {

    private final int count;
    private final String orderName;

    public MarineOrder(int count, String orderName){
        this.count = count;
        this.orderName = orderName;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getOrderName() {
        return orderName;
    }
}
