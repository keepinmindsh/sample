package pattern.sample.patternuse01.unit;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse01.unit.inf.Unit;
import pattern.sample.patternuse01.unit.status.UnitStatus;

@Slf4j
public class Marine implements Unit {

    private final UnitStatus unitStatus;

    public Marine(){
        unitStatus = UnitStatus.builder().health(70).build();
    }

    @Override
    public void checkStatus() {
        log.info("Marine Health : {}", unitStatus.getHealth());
    }
}
