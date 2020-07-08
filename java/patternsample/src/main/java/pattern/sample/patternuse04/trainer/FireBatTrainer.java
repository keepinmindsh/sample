package pattern.sample.patternuse04.trainer;

import pattern.sample.patternuse04.trainer.factory.Trainer;
import pattern.sample.patternuse04.unit.FireBat;
import pattern.sample.patternuse04.unit.inf.Unit;

public class FireBatTrainer extends Trainer {
    @Override
    public Unit createUnit() {
        return new FireBat();
    }
}
