package pattern.sample.patternuse13.building;

import pattern.sample.patternuse13.code.UnitType;
import pattern.sample.patternuse13.unit.FireBat;
import pattern.sample.patternuse13.unit.Marine;
import pattern.sample.patternuse13.unit.inf.Unit;

public class Barrack {

    public static Unit creatUnit(UnitType unitType){
        switch (unitType){
            case MARINE:
                return new Marine();
            case FIREBAT:
                return new FireBat(new Marine());
            default:
                return null;
        }
    }
}
