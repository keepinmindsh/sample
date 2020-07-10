package pattern.sample.patternuse06.template;

import pattern.sample.patternuse06.code.UnitType;
import pattern.sample.patternuse06.unit.action.inf.Action;

public abstract class Training {

    public Action trainingUnit(UnitType unitType){

        return training();
    }

    public abstract Action training();
}
