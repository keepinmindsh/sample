package pattern.sample.patternuse04.trainer;

import pattern.sample.patternuse04.trainer.factory.Trainer;
import pattern.sample.patternuse04.unit.Marine;
import pattern.sample.patternuse04.unit.inf.Unit;

public class MarineTrainer extends Trainer {
    @Override
    public Unit createUnit() {
        return new Marine();
    }
}
