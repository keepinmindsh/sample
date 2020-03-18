package designpattern.study.Package.Employee;

import designpattern.study.Package.Coffee.CoffeeProduct;
import designpattern.study.Package.CoffeeMachine;

public class Employee {

    public static CoffeeProduct ReceiveOrder(String order) {
        return CoffeeMachine.clickButton(order);
    }
}
