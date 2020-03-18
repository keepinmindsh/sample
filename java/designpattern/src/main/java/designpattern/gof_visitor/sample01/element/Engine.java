package designpattern.gof_visitor.sample01.element;

import designpattern.gof_visitor.sample01.visitors.CarElementVisitor;

public class Engine implements CarElement {
    @Override
    public void accept(CarElementVisitor carElementVisitor) {
        carElementVisitor.visit(this);
    }
}
