package pattern.sample.patternuse02.building;

import pattern.sample.patternuse02.building.inf.Building;
import pattern.sample.patternuse02.code.UnitType;
import pattern.sample.patternuse02.unit.inf.Unit;

public class Factory implements Building {
    @Override
    public Unit makeUnit(UnitType unitType) {
        return null;
    }
}
