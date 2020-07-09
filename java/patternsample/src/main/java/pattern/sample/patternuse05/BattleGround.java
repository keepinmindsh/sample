package pattern.sample.patternuse05;

import pattern.sample.patternuse05.building.Barrack;
import pattern.sample.patternuse05.code.UnitType;
import pattern.sample.patternuse05.unit.inf.Unit;

public class BattleGround {
    public static void main(String[] args) {
        Unit marine = Barrack.createUnit(UnitType.MARINE);

        Unit medic = Barrack.createUnit(UnitType.MEDIC);

        marine.action();

        medic.action();
    }
}
