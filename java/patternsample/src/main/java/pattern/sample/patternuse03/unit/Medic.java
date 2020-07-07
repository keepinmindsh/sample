package pattern.sample.patternuse03.unit;

import lombok.RequiredArgsConstructor;
import pattern.sample.patternuse03.equipment.inf.Armor;
import pattern.sample.patternuse03.equipment.inf.Gloves;
import pattern.sample.patternuse03.unit.inf.Unit;

@RequiredArgsConstructor
public class Medic implements Unit {

    private final Armor armor;
    private final Gloves gloves;
}

