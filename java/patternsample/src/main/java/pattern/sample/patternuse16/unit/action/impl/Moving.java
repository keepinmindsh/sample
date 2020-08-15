package pattern.sample.patternuse16.unit.action.impl;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse16.unit.action.Action;

@Slf4j
public class Moving implements Action {
    @Override
    public void act() {
        log.info("움직입니다. ");
    }
}
