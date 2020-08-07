package pattern.sample.patternuse15.unit.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse15.unit.inf.Unit;
import pattern.sample.patternuse15.unit.state.UnitState;

@RequiredArgsConstructor
@Slf4j
public class Medic implements Unit {

    private final UnitState unitState;

    @Override
    public void checkStatus() {
        log.info(unitState.toString());
    }
}
