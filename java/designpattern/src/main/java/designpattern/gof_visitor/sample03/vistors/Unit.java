package designpattern.gof_visitor.sample03.vistors;

import designpattern.gof_visitor.sample03.element.SionicStorm;

public interface Unit {
    void defense(SionicStorm sionicStorm);

    void destory(SionicStorm sionicStorm);
}
