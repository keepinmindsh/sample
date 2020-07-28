package pattern.sample.patternuse13;

import pattern.sample.patternuse13.building.Barrack;
import pattern.sample.patternuse13.code.UnitType;
import pattern.sample.patternuse13.unit.inf.Unit;

public class BattleGround {
    public static void main(String[] args) {
        Unit marinUnit = Barrack.creatUnit(UnitType.MARINE);
        Unit fireBatUnit = Barrack.creatUnit(UnitType.FIREBAT);

        marinUnit.attack();
        fireBatUnit.attack();
    }
}
