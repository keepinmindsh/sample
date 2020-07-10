package pattern.sample.patternuse06.building;

import pattern.sample.patternuse06.code.UnitType;
import pattern.sample.patternuse06.template.Training;
import pattern.sample.patternuse06.template.impl.MarineTraining;
import pattern.sample.patternuse06.template.impl.MedicTraining;
import pattern.sample.patternuse06.unit.Marine;
import pattern.sample.patternuse06.unit.Medic;
import pattern.sample.patternuse06.unit.inf.Unit;

public class Barrack {
    public static Unit createUnit(UnitType unitType){
        Training training;

        switch (unitType){
            case MARINE:
                training = new MarineTraining();


                return new Marine(training.training());

            case MEDIC:
                training = new MedicTraining();

                return new Medic(training.training());

            default:
                return null;
        }
    }
}
