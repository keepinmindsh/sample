package designpattern.gof_flyweight.sample02;

public interface Factory {
    public Unit serveUnit(Order order) throws Exception;
}
