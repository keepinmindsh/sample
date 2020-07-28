package pattern.sample.patternuse13_1.building;

import pattern.sample.patternuse13_1.code.UnitType;
import pattern.sample.patternuse13_1.unit.inf.Unit;

public class Barrack {
    public static Unit createUnit(UnitType unitType){
        switch (unitType){
            case MARINE:
                return null;
            case FIREBAT:
                return null;
            case MEDIC:
                return null;
            default:
                return null;
        }
    }
}
