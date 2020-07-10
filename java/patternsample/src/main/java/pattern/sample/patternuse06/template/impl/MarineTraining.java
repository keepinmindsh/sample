package pattern.sample.patternuse06.template.impl;

import pattern.sample.patternuse06.template.Training;
import pattern.sample.patternuse06.unit.action.Attack;
import pattern.sample.patternuse06.unit.action.inf.Action;

public class MarineTraining extends Training {
    @Override
    public Action training() {
        return new Attack();
    }
}
