package pattern.sample.patternuse12;

import pattern.sample.patternuse12.building.Barrack;
import pattern.sample.patternuse12.code.UnitType;
import pattern.sample.patternuse12.unit.inf.Unit;

public class BattleGround {
    public static void main(String[] args) {
        Barrack barrack = new Barrack();

        Unit marineUnit = barrack.createUnit(UnitType.MARINE);
        Unit medicUnit = barrack.createUnit(UnitType.MEDIC);
    }
}
