package designpattern.gof_decorator.sample02.dough;

import designpattern.gof_decorator.sample02.topping.Topping;

public abstract class DoughDecorator {
    public abstract Topping addTopping(String toppingName);
}
