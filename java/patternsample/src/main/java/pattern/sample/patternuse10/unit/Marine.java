package pattern.sample.patternuse10.unit;

import lombok.RequiredArgsConstructor;
import pattern.sample.patternuse10.action.composite.Action;
import pattern.sample.patternuse10.code.ActionType;
import pattern.sample.patternuse10.unit.inf.Unit;

@RequiredArgsConstructor
public class Marine implements Unit {
    private final Action action;

    @Override
    public void act(ActionType actionType) {
        action.action(actionType).act();
    }
}
