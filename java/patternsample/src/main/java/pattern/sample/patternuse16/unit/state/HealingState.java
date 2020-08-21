package pattern.sample.patternuse16.unit.state;


import pattern.sample.patternuse16.unit.action.Action;
import pattern.sample.patternuse16.unit.action.impl.Healing;
import pattern.sample.patternuse16.unit.code.ActionType;
import pattern.sample.patternuse16.unit.state.structure.UnitState;

public class HealingState extends UnitState {
    @Override
    public Action byAction() {
        return new Healing();
    }
}
