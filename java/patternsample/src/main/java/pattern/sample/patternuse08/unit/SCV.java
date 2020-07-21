package pattern.sample.patternuse08.unit;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse08.unit.inf.Unit;

@Slf4j
public class SCV implements Unit {
    public SCV() {
        log.info("SCV이 생성되었습니다.");
    }
}
