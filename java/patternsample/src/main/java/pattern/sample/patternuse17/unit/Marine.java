package pattern.sample.patternuse17.unit;

import pattern.sample.patternuse17.unit.action.Action;

import java.util.Optional;

public class Marine {

    public Action action;

    public void setAction(Action action){
        this.action = action;
    }

    public void act(){
        Optional.ofNullable(this.action)
                .ifPresent(action -> {
                    action.act();
                });
    }
}
