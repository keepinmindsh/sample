package pattern.sample.patternuse04;

import pattern.sample.patternuse04.building.Barrack;
import pattern.sample.patternuse04.code.UnitType;
import pattern.sample.patternuse04.unit.inf.Unit;

public class BattleGround {
    public static void main(String[] args) {

        Unit marine = Barrack.createUnit(UnitType.MARINE);
        Unit medic = Barrack.createUnit(UnitType.MEDIC);
        Unit firebat = Barrack.createUnit(UnitType.FIREBAT);

        marine.action();
        medic.action();
        firebat.action();
    }
}
