package pattern.sample.patternuse16;

import pattern.sample.patternuse16.unit.Marine;
import pattern.sample.patternuse16.unit.code.ActionType;

public class BattleGround {
    public static void main(String[] args) {
        Marine marine = new Marine();

        marine.actionByMouse(ActionType.MOVING);

        marine.actionByMouse(ActionType.ATTACK);

        marine.actionByMouse(ActionType.MOVING);

        marine.actionByMouse(ActionType.HEALING);
    }
}
