package pattern.sample.patternuse16.unit;

import pattern.sample.patternuse16.unit.action.Action;
import pattern.sample.patternuse16.unit.code.ActionType;
import pattern.sample.patternuse16.unit.state.structure.UnitState;

public class Marine {

    public void actionByMouse(ActionType actionType){

        Action action = UnitState
                .byState(actionType)
                .byAction();

        action.act();
    }
}
