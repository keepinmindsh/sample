package designpattern.gof_decorator.sample02.dough;

import designpattern.gof_decorator.sample02.topping.Topping;

public class Dough extends DoughDecorator {

    private final DoughStyle doughStyle;

    public Dough(DoughStyle doughStyle){
        this.doughStyle = doughStyle;
    }

    public String getDough() {
        return doughStyle.toString();
    }

    @Override
    public Topping addTopping(String toppingName) {
        return null;
    }
}
