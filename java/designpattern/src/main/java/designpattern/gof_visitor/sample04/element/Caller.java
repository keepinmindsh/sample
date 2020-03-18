package designpattern.gof_visitor.sample04.element;

import designpattern.gof_visitor.sample04.Visitor.PrintVisitor;

import java.util.ArrayList;
import java.util.List;

public class Caller implements PrinterElement {

    List<PrinterElement> printList;

    public Caller(){

        printList = new ArrayList<>();

        printList.add(new Front());
        printList.add(new POS());
        printList.add(new WEB());
    }

    @Override
    public void accept(PrintVisitor printVisitor) {
        printList.forEach(value -> value.accept(printVisitor));
    }
}
