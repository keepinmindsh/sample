package pattern.sample.patternuse02.unit;

import pattern.sample.patternuse02.command.inf.Command;
import pattern.sample.patternuse02.unit.inf.Unit;

public class NotUnit implements Unit {
    @Override
    public Command action() {
        return null;
    }
}
