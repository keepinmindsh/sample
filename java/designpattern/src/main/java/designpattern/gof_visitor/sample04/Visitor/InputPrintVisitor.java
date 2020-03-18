package designpattern.gof_visitor.sample04.Visitor;

import designpattern.gof_visitor.sample04.element.Front;
import designpattern.gof_visitor.sample04.element.Kiosk;
import designpattern.gof_visitor.sample04.element.POS;
import designpattern.gof_visitor.sample04.element.WEB;

public class InputPrintVisitor implements PrintVisitor {

    @Override
    public void visit(Front front) {
        System.out.println("프론트 데이터를 입력했습니다.");
    }

    @Override
    public void visit(POS pos) {
        System.out.println("포스 데이터를 입력했습니다.");
    }

    @Override
    public void visit(WEB web) {
        System.out.println("웹 데이터를 입력했습니다.");
    }

    @Override
    public void visit(Kiosk kiosk) {

    }
}
