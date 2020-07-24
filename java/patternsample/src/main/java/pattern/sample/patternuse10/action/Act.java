package pattern.sample.patternuse10.action;

import pattern.sample.patternuse10.action.composite.Action;
import pattern.sample.patternuse10.code.ActionType;

import java.util.concurrent.atomic.AtomicReference;

public class Act extends Action {

    @Override
    public Action action(ActionType actionType){

        AtomicReference<Action> action = new AtomicReference<>();

        super.actionList.forEach(actionFromList -> {
            switch (actionType){
                case RUNNING:
                    if(actionFromList instanceof Running){
                        action.set(actionFromList);
                    }
                    return;
                case HIDING:
                    if(actionFromList instanceof Hiding) {
                        action.set(actionFromList);
                    }
                    return;
                case WALK:
                    if(actionFromList instanceof Walking ){
                        action.set(actionFromList);
                    }
                    return;
            }
        });

        return action.get();
    }

    @Override
    public void act() {

    }
}
