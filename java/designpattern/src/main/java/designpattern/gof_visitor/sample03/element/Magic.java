package designpattern.gof_visitor.sample03.element;

import designpattern.gof_visitor.sample03.vistors.Unit;

public interface Magic {
    void Accept(Unit unit);
}
