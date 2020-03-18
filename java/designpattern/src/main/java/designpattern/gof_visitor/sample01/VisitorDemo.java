package designpattern.gof_visitor.sample01;

import designpattern.gof_visitor.sample01.element.Car;
import designpattern.gof_visitor.sample01.visitors.CarElementDoVisitor;
import designpattern.gof_visitor.sample01.visitors.CarElementPrintVisitor;

public class VisitorDemo {
    public static void main(String[] args) {
        Car car = new Car();

        car.accept(new CarElementPrintVisitor());
        car.accept(new CarElementDoVisitor());
    }
}
