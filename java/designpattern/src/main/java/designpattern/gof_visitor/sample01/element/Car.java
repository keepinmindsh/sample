package designpattern.gof_visitor.sample01.element;

import designpattern.gof_visitor.sample01.visitors.CarElementVisitor;

public class Car implements CarElement {

    CarElement[] elements;

    public CarElement[] getElements(){
        return elements.clone();
    }

    public Car(){
        this.elements = new CarElement[]{
            new Wheel("front left"), new Wheel("front right"),
            new Wheel("back left"), new Wheel("back right"),
            new Body(), new Engine()};
    }
    @Override
    public void accept(CarElementVisitor carElementVisitor) {
        for(CarElement carElement : this.getElements()) {
            carElement.accept(carElementVisitor);
        }
        carElementVisitor.visit(this);
    }
}
