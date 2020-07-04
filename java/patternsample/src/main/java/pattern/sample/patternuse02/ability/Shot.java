package pattern.sample.patternuse02.ability;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse02.ability.inf.Ability;

@Slf4j
public class Shot implements Ability {
    @Override
    public void apply() {
        log.info("총을 쏜다.");
    }
}
