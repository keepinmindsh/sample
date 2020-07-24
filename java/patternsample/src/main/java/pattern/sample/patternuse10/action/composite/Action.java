package pattern.sample.patternuse10.action.composite;

import pattern.sample.patternuse10.action.Hiding;
import pattern.sample.patternuse10.action.Running;
import pattern.sample.patternuse10.action.Walking;
import pattern.sample.patternuse10.code.ActionType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Action {

    protected List<Action> actionList = new ArrayList<>();

    public void actionAdd(Action action){
        actionList.add(action);
    }

    public Action action(ActionType actionType){

        AtomicReference<Action> action = new AtomicReference<>();

        actionList.forEach(actionFromList -> {
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

    public abstract void act();
}
