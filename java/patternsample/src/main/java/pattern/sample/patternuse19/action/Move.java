package pattern.sample.patternuse19.action;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Move implements Action {
    @Override
    public void act() {
        log.info("Moving");
    }
}
