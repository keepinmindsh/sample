package designpattern.gof_decorator.sample02.pizza;

public class PotatoPizza implements Pizza {
    @Override
    public String createPizza() {
        return "Potato Pizza";
    }
}
