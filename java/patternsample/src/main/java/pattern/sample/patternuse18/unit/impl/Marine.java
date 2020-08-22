package pattern.sample.patternuse18.unit.impl;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse18.unit.Unit;

@Slf4j
public class Marine implements Unit {
    @Override
    public void act() {
        log.info(" 행동합니다.");
    }
}
