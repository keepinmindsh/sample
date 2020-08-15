package pattern.sample.patternuse16.unit.state;


import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse16.unit.action.Action;
import pattern.sample.patternuse16.unit.action.impl.Attack;
import pattern.sample.patternuse16.unit.code.ActionType;
import pattern.sample.patternuse16.unit.state.structure.UnitState;

@Slf4j
public class AttackState extends UnitState {

    @Override
    public Action byAction() {
        return new Attack();
    }
}
