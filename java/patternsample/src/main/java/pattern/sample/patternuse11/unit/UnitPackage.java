package pattern.sample.patternuse11.unit;

import lombok.RequiredArgsConstructor;
import pattern.sample.patternuse11.unit.composit.Unit;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UnitPackage extends Unit {

    private final List<Unit> unitList;
    private List<Unit> filteredUnitList = new ArrayList<>();

    public void add(Unit unit){
        unitList.add(unit);
    }

    public List<Unit> getSpecs(){
        return filteredUnitList;
    }

    @Override
    public boolean checkUnitStatus() {
        return false;
    }
}
