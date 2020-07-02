package pattern.sample.patternuse01.unit;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse01.unit.inf.Unit;

@Slf4j
public class Empty implements Unit {

    @Override
    public void checkStatus() {
        log.info("Empty, do nothing!");
    }
}
