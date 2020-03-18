package designpattern.gof_visitor.sample04.element;

import designpattern.gof_visitor.sample04.Visitor.PrintVisitor;

public interface PrinterElement {
    public void accept(PrintVisitor printVisitor);
}
