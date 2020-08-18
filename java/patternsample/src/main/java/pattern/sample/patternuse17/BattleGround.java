package pattern.sample.patternuse17;

import pattern.sample.patternuse17.unit.Marine;
import pattern.sample.patternuse17.unit.action.impl.Move;
import pattern.sample.patternuse17.unit.action.impl.NullAction;

public class BattleGround {
    public static void main(String[] args) {
        Marine marine = new Marine();

        marine.setAction(new Move());

        marine.act();

        marine.setAction(new NullAction());

        marine.act();
    }
}
