package pattern.sample.patternuse08;

import pattern.sample.patternuse08.building.Barrack;
import pattern.sample.patternuse08.code.UnitType;
import pattern.sample.patternuse08.unit.inf.Unit;
import pattern.sample.patternuse08.unitBuilder.UnitBuilder;

public class BattleGround {
    public static void main(String[] args) {
        Unit marine = Barrack.createUnit(UnitBuilder.builder()
                                    .unitName("Marine")
                                    .unitType(UnitType.MARINE).build());


    }
}
