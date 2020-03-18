package designpattern.gof_visitor.sample01.visitors;

import designpattern.gof_visitor.sample01.element.Body;
import designpattern.gof_visitor.sample01.element.Car;
import designpattern.gof_visitor.sample01.element.Engine;
import designpattern.gof_visitor.sample01.element.Wheel;

public interface CarElementVisitor {
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visit(Car car);
}
