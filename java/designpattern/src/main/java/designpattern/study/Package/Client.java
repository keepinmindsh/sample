package designpattern.study.Package;


import designpattern.study.Package.Coffee.CoffeeProduct;
import designpattern.study.Package.Employee.Employee;

public class Client {

    public static void main(String[] args) {


        CoffeeProduct espresso1 = Employee.ReceiveOrder("Espresso");

        CoffeeProduct Americano1 = Employee.ReceiveOrder("Americano");
        CoffeeProduct Americano2 = Employee.ReceiveOrder("Americano");
        CoffeeProduct Americano3 = Employee.ReceiveOrder("Americano");

        CoffeeProduct Cafelatte1 = Employee.ReceiveOrder("Cafelatte");
        CoffeeProduct Cafelatte2 = Employee.ReceiveOrder("Cafelatte");
        CoffeeProduct Cafelatte3 = Employee.ReceiveOrder("Cafelatte");


        CoffeeProduct CafeMoka1 = Employee.ReceiveOrder("CafeMoka");
        CoffeeProduct CafeMoka2 = Employee.ReceiveOrder("CafeMoka");

        espresso1.oneBottleOfCoffee();
        Americano1.oneBottleOfCoffee();
        Americano2.oneBottleOfCoffee();
        Americano3.oneBottleOfCoffee();
        Cafelatte1.oneBottleOfCoffee();
        Cafelatte2.oneBottleOfCoffee();
        Cafelatte3.oneBottleOfCoffee();
        CafeMoka1.oneBottleOfCoffee();
        CafeMoka2.oneBottleOfCoffee();

    }
}
