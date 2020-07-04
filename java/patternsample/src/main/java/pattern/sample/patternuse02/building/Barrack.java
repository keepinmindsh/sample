package pattern.sample.patternuse02.building;

import pattern.sample.patternuse02.ability.Heal;
import pattern.sample.patternuse02.ability.Shot;
import pattern.sample.patternuse02.building.inf.Building;
import pattern.sample.patternuse02.code.UnitType;
import pattern.sample.patternuse02.unit.Marine;
import pattern.sample.patternuse02.unit.Medic;
import pattern.sample.patternuse02.unit.NotUnit;
import pattern.sample.patternuse02.unit.inf.Unit;

public class Barrack implements Building {

    public Unit makeUnit(UnitType unitType){

        switch (unitType){
            case MARINE:
                return new Marine(new Shot());
            case MEDIC:
                return new Medic(new Heal());
            default:
                return new NotUnit();
        }
    }
}
