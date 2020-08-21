package pattern.sample.patternuse16.unit.state;


import pattern.sample.patternuse16.unit.action.Action;
import pattern.sample.patternuse16.unit.action.impl.Moving;
import pattern.sample.patternuse16.unit.state.structure.UnitState;

public class MovingState extends UnitState {
    @Override
    public Action byAction() {
        return new Moving();
    }
}
