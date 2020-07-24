package pattern.sample.patternuse10.action;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse10.action.composite.Action;

@Slf4j
public class Hiding extends Action {
    @Override
    public void act() {
        log.info("Hiding Action start!");
    }
}
