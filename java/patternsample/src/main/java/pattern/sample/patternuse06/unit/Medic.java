package pattern.sample.patternuse06.unit;

import lombok.RequiredArgsConstructor;
import pattern.sample.patternuse06.unit.action.inf.Action;
import pattern.sample.patternuse06.unit.inf.Unit;

@RequiredArgsConstructor
public class Medic implements Unit {

    private final Action action;

    @Override
    public void Action() {
        action.act();
    }
}
