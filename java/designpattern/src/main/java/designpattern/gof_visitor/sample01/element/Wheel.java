package designpattern.gof_visitor.sample01.element;

import designpattern.gof_visitor.sample01.visitors.CarElementVisitor;

public class Wheel implements CarElement {

    private String name;

    public Wheel(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void accept(CarElementVisitor carElementVisitor) {
        carElementVisitor.visit(this);
    }
}
