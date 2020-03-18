package designpattern.gof_visitor.sample03.element;

import designpattern.gof_visitor.sample03.vistors.Unit;

public class SionicStorm implements Magic {

    private int demage = 100;

    public int getDemage(){
        return demage;
    }

    @Override
    public void Accept(Unit unit) {
        unit.defense(this);

        unit.destory(this);
    }
}
