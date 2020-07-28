package pattern.sample.patternuse13.unit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse13.unit.inf.Unit;

@RequiredArgsConstructor
@Slf4j
public class FireBat implements Unit {

    private final Marine marine;

    @Override
    public void attack() {

        log.info("불을 이용해서 ");

        marine.attack();
    }
}
