package pattern.sample.patternuse10;

import pattern.sample.patternuse10.action.Act;
import pattern.sample.patternuse10.action.Hiding;
import pattern.sample.patternuse10.action.Running;
import pattern.sample.patternuse10.action.Walking;
import pattern.sample.patternuse10.action.composite.Action;
import pattern.sample.patternuse10.code.ActionType;
import pattern.sample.patternuse10.unit.Marine;
import pattern.sample.patternuse10.unit.inf.Unit;

public class BattleGround {
    public static void main(String[] args) {

        Action action = new Act();

        action.actionAdd(new Running());
        action.actionAdd(new Hiding());
        action.actionAdd(new Walking());

        Unit marine = new Marine(action);

        marine.act(ActionType.HIDING);
        marine.act(ActionType.HIDING);
        marine.act(ActionType.WALK);
        marine.act(ActionType.RUNNING);
    }
}
