package pattern.sample.patternuse11.building;

import pattern.sample.patternuse11.unit.UnitPackage;
import pattern.sample.patternuse11.unit.composit.Unit;

import java.util.List;

public class Barrack {

    public boolean isTrainedUnit(Unit unit){

        // isTrainedUnit에 대한 중복 로직을 해당 메소드에서 공통적으로 처리할 수 있다.

        return unit.checkUnitStatus();
    }

    public boolean isTrainedUnit(List<Unit> unitList){
        return isTrainedUnit(new UnitPackage(unitList));
    }
}
