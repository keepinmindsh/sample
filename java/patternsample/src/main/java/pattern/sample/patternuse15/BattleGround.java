package pattern.sample.patternuse15;

import pattern.sample.patternuse15.unit.impl.Marine;
import pattern.sample.patternuse15.unit.impl.Medic;
import pattern.sample.patternuse15.unit.inf.Unit;
import pattern.sample.patternuse15.unit.state.UnitState;

public class BattleGround {
    public static void main(String[] args) {
        Unit marine = new Marine(UnitState.NORMAL);
        Unit medic = new Medic(UnitState.HURT);

        marine.checkStatus();
        medic.checkStatus();

    }
}
