package pattern.sample.patternuse16.unit.state.structure;

import pattern.sample.patternuse16.unit.action.Action;
import pattern.sample.patternuse16.unit.code.ActionType;
import pattern.sample.patternuse16.unit.state.AttackState;
import pattern.sample.patternuse16.unit.state.HealingState;
import pattern.sample.patternuse16.unit.state.MovingState;

public abstract class UnitState {

    public final static UnitState MOVING = new MovingState();
    public final static UnitState ATTACK = new AttackState();
    public final static UnitState HEALING = new HealingState();

    public static UnitState byState(ActionType actionType){
        switch (actionType){
            case ATTACK:
                return ATTACK;
            case MOVING:
                return MOVING;
            case HEALING:
                return HEALING;
            default:
                return null;
        }
    }

    public abstract Action byAction();
}
