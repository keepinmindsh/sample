package pattern.sample.patternuse02.ability;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse02.ability.inf.Ability;

@Slf4j
public class Heal implements Ability {
    @Override
    public void apply() {
        log.info("치료한다.");
    }
}
