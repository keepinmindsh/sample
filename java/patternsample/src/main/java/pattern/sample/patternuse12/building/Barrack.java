package pattern.sample.patternuse12.building;

import pattern.sample.patternuse12.code.UnitType;
import pattern.sample.patternuse12.unit.Marine;
import pattern.sample.patternuse12.unit.Medic;
import pattern.sample.patternuse12.unit.inf.Unit;

import java.util.HashMap;
import java.util.Map;

public class Barrack {

    private final Map<UnitType, Unit> unitMap;

    public Barrack(){
        unitMap = new HashMap<>();

        unitMap.put(UnitType.MARINE, new Marine());
        unitMap.put(UnitType.MEDIC, new Medic());
    }

    public Unit createUnit(UnitType unitType){
        return unitMap.get(unitType);
    }
}
