package pattern.sample.patternuse08.building;

import pattern.sample.patternuse08.unit.inf.Unit;
import pattern.sample.patternuse08.unitBuilder.UnitBuilder;

public class Barrack {

    public static Unit createUnit(UnitBuilder unitBuilder){
        return unitBuilder.createUnit();
    }

}
