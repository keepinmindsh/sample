package pattern.sample.patternuse02.unit;

import lombok.RequiredArgsConstructor;
import pattern.sample.patternuse02.ability.inf.Ability;
import pattern.sample.patternuse02.command.inf.Command;
import pattern.sample.patternuse02.unit.inf.Unit;

@RequiredArgsConstructor
public class Marine implements Unit {

    private final Ability ability;

    @Override
    public Command action() {

        ability.apply();

        return null;
    }
}
