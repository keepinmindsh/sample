package pattern.sample.patternuse01;

import pattern.sample.patternuse01.building.Barrack;
import pattern.sample.patternuse01.code.UnitType;
import pattern.sample.patternuse01.unit.inf.Unit;

public class BattleGround {

    public static void main(String[] args) {

        Unit marine = Barrack.createUnit(UnitType.MARINE);

        marine.checkStatus();

        Unit medic = Barrack.createUnit(UnitType.MEDIC);

        medic.checkStatus();

    }
}
