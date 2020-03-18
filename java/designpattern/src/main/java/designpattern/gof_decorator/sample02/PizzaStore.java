package designpattern.gof_decorator.sample02;

import designpattern.gof_decorator.sample02.oven.PizzaOven;

import java.lang.reflect.InvocationTargetException;

public class PizzaStore {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        String value = PizzaOven.providePizza("designpattern.gof_decorator.sample02.pizza.PotatoPizza");

        System.out.println(value);
    }
}
