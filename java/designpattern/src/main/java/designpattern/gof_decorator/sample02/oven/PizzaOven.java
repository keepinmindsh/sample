package designpattern.gof_decorator.sample02.oven;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PizzaOven {
    public static String providePizza(String pizzaName) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        Method[] methods = Class.forName(pizzaName).getMethods();

        String pizza = "";

        for (int i = 0; i < methods.length; i++) {
           pizza = (String) methods[i].invoke("test", "11");
        }

        return pizza;
    }
}
