package pattern.sample.patternuse07.unit.impl;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse07.unit.inf.Unit;

@Slf4j
public class Marine implements Unit {
    @Override
    public void checkUnit() {
        log.info("Marine 입니다.");
    }
}
