package pattern.sample.patternuse17.unit.action.impl;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse17.unit.action.Action;

@Slf4j
public class Move implements Action {
    @Override
    public void act() {
        log.info("Move!!");
    }
}
