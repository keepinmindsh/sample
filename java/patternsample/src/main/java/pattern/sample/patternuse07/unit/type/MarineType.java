package pattern.sample.patternuse07.unit.type;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse07.unit.UnitComposite;

@Slf4j
public class MarineType extends UnitComposite {

    @Override
    public void trainingUnit() {
        log.info("마린 훈련을 시작합니다. ");
    }
}
