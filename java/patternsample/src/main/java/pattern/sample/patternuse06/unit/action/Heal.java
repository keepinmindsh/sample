package pattern.sample.patternuse06.unit.action;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse06.unit.action.inf.Action;

@Slf4j
public class Heal implements Action {
    @Override
    public void act() {
        log.info("치료하다.");
    }
}
