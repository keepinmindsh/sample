package designpattern.gof_visitor.sample04.Visitor;

import designpattern.gof_visitor.sample04.element.Front;
import designpattern.gof_visitor.sample04.element.Kiosk;
import designpattern.gof_visitor.sample04.element.POS;
import designpattern.gof_visitor.sample04.element.WEB;

public class OutputPrintVisitor implements PrintVisitor {


    @Override
    public void visit(Front front) {
        System.out.println("프론트 출력했습니다.");
    }

    @Override
    public void visit(POS pos) {
        System.out.println("포스를 출력했습니다.");
    }

    @Override
    public void visit(WEB web) {
        System.out.println("웹을 출력했습니다.");
    }

    @Override
    public void visit(Kiosk kiosk) {

    }
}
