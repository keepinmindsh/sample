package designpattern.gof_abstractFactory.sample002;

public abstract class Product {

    public abstract String getName();

    public abstract int getPrice();

    @Override
    public String toString() {
        return "product name : " + getName() + ", price " + getPrice();
    }
}
