package pattern.sample.patternuse02.building.inf;

import pattern.sample.patternuse02.code.UnitType;
import pattern.sample.patternuse02.unit.inf.Unit;

public interface Building {
    public Unit makeUnit(UnitType unitType);
}
