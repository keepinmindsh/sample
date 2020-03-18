package designpattern.gof_visitor.sample01.visitors;

import designpattern.gof_visitor.sample01.element.Body;
import designpattern.gof_visitor.sample01.element.Car;
import designpattern.gof_visitor.sample01.element.Engine;
import designpattern.gof_visitor.sample01.element.Wheel;

public class CarElementPrintVisitor implements CarElementVisitor {
    @Override
    public void visit(Wheel wheel) {
        System.out.println("Visiting " + wheel.getName() + " wheel");
    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Visit Engine");
    }

    @Override
    public void visit(Body body) {
        System.out.println("Visiting body");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Visiting Car");
    }
}
