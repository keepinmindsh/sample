package pattern.sample.patternuse04.trainer;

import pattern.sample.patternuse04.trainer.factory.Trainer;
import pattern.sample.patternuse04.unit.Medic;
import pattern.sample.patternuse04.unit.inf.Unit;

public class MedicTrainer extends Trainer {
    @Override
    public Unit createUnit() {
        return new Medic();
    }
}
