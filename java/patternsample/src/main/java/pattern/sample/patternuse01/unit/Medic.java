package pattern.sample.patternuse01.unit;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse01.unit.inf.Unit;
import pattern.sample.patternuse01.unit.status.UnitStatus;

@Slf4j
public class Medic implements Unit {
    private final UnitStatus unitStatus;

    public Medic(){
        unitStatus = UnitStatus.builder().health(50).build();
    }

    @Override
    public void checkStatus(){
        log.info("Medic Health : {}", unitStatus.getHealth());
    }
}
