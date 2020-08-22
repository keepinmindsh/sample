package pattern.sample.patternuse19;

import pattern.sample.patternuse19.action.Move;
import pattern.sample.patternuse19.mouse.Mouse;

public class BattleGround {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();

        mouse.addAction(new Move());
        mouse.addAction(new Move());
        mouse.addAction(new Move());
        mouse.addAction(new Move());

        mouse.notifyForAction();
    }
}
