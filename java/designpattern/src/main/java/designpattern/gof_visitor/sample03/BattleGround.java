package designpattern.gof_visitor.sample03;

import designpattern.gof_visitor.sample03.element.HighTemplar;
import designpattern.gof_visitor.sample03.element.SionicStorm;
import designpattern.gof_visitor.sample03.vistors.Marine;

public class BattleGround {
    public static void main(String[] args) {
        HighTemplar highTemplar = new HighTemplar();

        highTemplar.setMagics(new SionicStorm());

        highTemplar.Accept(new Marine());
    }
}
