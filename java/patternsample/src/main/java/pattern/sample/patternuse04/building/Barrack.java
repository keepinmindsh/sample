package pattern.sample.patternuse04.building;

import pattern.sample.patternuse04.code.UnitType;
import pattern.sample.patternuse04.trainer.FireBatTrainer;
import pattern.sample.patternuse04.trainer.MarineTrainer;
import pattern.sample.patternuse04.trainer.MedicTrainer;
import pattern.sample.patternuse04.trainer.factory.Trainer;
import pattern.sample.patternuse04.unit.inf.Unit;

public class Barrack {

    public static Unit createUnit(UnitType unitType){

        Trainer trainer;

        switch (unitType){
            case MARINE:
                trainer = new MarineTrainer();
            case MEDIC:
                trainer = new MedicTrainer();
            default:
                trainer = new FireBatTrainer();
        }

        return trainer.createUnit();
    }
}
