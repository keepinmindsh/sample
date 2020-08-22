package pattern.sample.patternuse19.mouse;

import pattern.sample.patternuse19.action.Action;

import java.util.ArrayList;
import java.util.List;

public class Mouse {

    private final List<Action> actionList = new ArrayList<>();

    public void addAction(Action action){
        actionList.add(action);
    }

    public void notifyForAction(){
        actionList.forEach(Action::act);
    }
}
