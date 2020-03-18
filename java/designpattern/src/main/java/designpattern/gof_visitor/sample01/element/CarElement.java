package designpattern.gof_visitor.sample01.element;

import designpattern.gof_visitor.sample01.visitors.CarElementVisitor;

public interface CarElement {
    void accept(CarElementVisitor carElementVisitor);
}
