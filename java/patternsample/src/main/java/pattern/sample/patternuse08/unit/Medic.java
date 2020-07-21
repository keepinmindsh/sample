package pattern.sample.patternuse08.unit;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse08.unit.inf.Unit;

@Slf4j
public class Medic implements Unit {
    public Medic(){
        log.info("Medic이 생성되었습니다.");
    }
}
