package designpattern.gof_visitor.sample04.element;

import designpattern.gof_visitor.sample04.Visitor.PrintVisitor;

public class Front implements PrinterElement {
    @Override
    public void accept(PrintVisitor printVisitor) {
        printVisitor.visit(this);
    }
}
