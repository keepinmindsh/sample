package pattern.sample.patternuse01.building;

import pattern.sample.patternuse01.code.UnitType;
import pattern.sample.patternuse01.unit.Empty;
import pattern.sample.patternuse01.unit.Marine;
import pattern.sample.patternuse01.unit.Medic;
import pattern.sample.patternuse01.unit.inf.Unit;

public class Barrack {

    public static Unit createUnit(UnitType unitType){
        switch (unitType){
            case MEDIC:
                return new Medic();
            case MARINE:
                return new Marine();
            default:
                return new Empty();
        }

    }
}
