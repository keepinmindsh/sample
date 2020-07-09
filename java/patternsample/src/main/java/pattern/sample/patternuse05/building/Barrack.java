package pattern.sample.patternuse05.building;

import pattern.sample.patternuse05.ability.Attack;
import pattern.sample.patternuse05.ability.Heal;
import pattern.sample.patternuse05.code.UnitType;
import pattern.sample.patternuse05.unit.Marine;
import pattern.sample.patternuse05.unit.Medic;
import pattern.sample.patternuse05.unit.inf.Unit;

public class Barrack {
    public static Unit createUnit(UnitType unitType){
        switch (unitType){
            case MARINE:
                return new Marine(new Attack());
            case MEDIC:
                return new Medic(new Heal());
            default:
                return null;
        }
    }
}
