package pattern.sample.patternuse13.unit;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse13.unit.inf.Unit;

@Slf4j
public class Marine implements Unit {
    @Override
    public void attack() {
        log.info("공격 합니다!");
    }
}
