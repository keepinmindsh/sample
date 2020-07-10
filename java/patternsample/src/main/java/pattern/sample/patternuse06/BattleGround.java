package pattern.sample.patternuse06;

import pattern.sample.patternuse06.building.Barrack;
import pattern.sample.patternuse06.code.UnitType;
import pattern.sample.patternuse06.unit.inf.Unit;

public class BattleGround {
    public static void main(String[] args) {
        Unit marine = Barrack.createUnit(UnitType.MARINE);

        marine.Action();

        Unit medic = Barrack.createUnit(UnitType.MEDIC);

        medic.Action();
    }
}
