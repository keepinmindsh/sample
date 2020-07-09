package pattern.sample.patternuse05.unit;

import lombok.RequiredArgsConstructor;
import pattern.sample.patternuse05.ability.inf.Action;
import pattern.sample.patternuse05.unit.inf.Unit;

@RequiredArgsConstructor
public class Medic implements Unit {

    private final Action action;

    @Override
    public void action() {
        action.act();
    }
}
