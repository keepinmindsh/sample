package pattern.sample.patternuse02.ability;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse02.ability.inf.Ability;

@Slf4j
public class Nothing implements Ability {
    @Override
    public void apply() {
        log.info("아무것도 발생하지 않았습니다. ");
    }
}
