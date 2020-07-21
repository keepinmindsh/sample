package pattern.sample.patternuse08.unitBuilder;

import lombok.Builder;
import pattern.sample.patternuse08.code.UnitType;
import pattern.sample.patternuse08.unit.Marine;
import pattern.sample.patternuse08.unit.Medic;
import pattern.sample.patternuse08.unit.SCV;
import pattern.sample.patternuse08.unit.inf.Unit;

public class UnitBuilder {

    private final String unitName;
    private final UnitType unitType;

    @Builder
    public UnitBuilder(String unitName, UnitType unitType){
        this.unitName = unitName;
        this.unitType = unitType;
    }

    public Unit createUnit(){
        switch (unitType){
            case MEDIC:
                return new Medic();
            case MARINE:
                return new Marine();
            default:
                return new SCV();
        }
    }
}
