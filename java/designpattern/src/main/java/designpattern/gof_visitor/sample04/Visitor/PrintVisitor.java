package designpattern.gof_visitor.sample04.Visitor;

import designpattern.gof_visitor.sample04.element.Front;
import designpattern.gof_visitor.sample04.element.Kiosk;
import designpattern.gof_visitor.sample04.element.POS;
import designpattern.gof_visitor.sample04.element.WEB;

public interface PrintVisitor {
    public void visit(Front front);
    public void visit(POS pos);
    public void visit(WEB web);
    public void visit(Kiosk kiosk);
}
