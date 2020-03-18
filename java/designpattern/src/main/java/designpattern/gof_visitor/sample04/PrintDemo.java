package designpattern.gof_visitor.sample04;

import designpattern.gof_visitor.sample04.Visitor.InputPrintVisitor;
import designpattern.gof_visitor.sample04.Visitor.LoadPrintVisiter;
import designpattern.gof_visitor.sample04.Visitor.OutputPrintVisitor;
import designpattern.gof_visitor.sample04.element.Caller;

public class PrintDemo {

    public static void main(String[] args) {

        Caller caller = new Caller();

        caller.accept(new InputPrintVisitor());
        caller.accept(new LoadPrintVisiter());
        caller.accept(new OutputPrintVisitor());
    }
}
