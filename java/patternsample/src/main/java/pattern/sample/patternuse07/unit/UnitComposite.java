package pattern.sample.patternuse07.unit;

import lombok.RequiredArgsConstructor;
import pattern.sample.patternuse07.unit.impl.Marine;
import pattern.sample.patternuse07.unit.impl.Medic;
import pattern.sample.patternuse07.unit.inf.Unit;
import pattern.sample.patternuse07.unit.type.MarineType;
import pattern.sample.patternuse07.unit.type.MedicType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UnitComposite {

    private final List<UnitComposite> unitCompositeList = new ArrayList<>();
    private List<Unit> unitList;

    public void trainingUnit(){
        unitList = unitCompositeList.stream().map(trainingType -> {
            trainingType.trainingUnit();

            if(trainingType instanceof MarineType){
                return new Marine();
            }else if(trainingType instanceof MedicType){
                return new Medic();
            }else {
                return null;
            }
        }).collect(Collectors.toList());
    }

    public void checkTrainedUnit(){
        unitList.forEach(Unit::checkUnit);
    }

    public void addTrainedUnit(UnitComposite unitComposite){
        unitCompositeList.add(unitComposite);
    }
}
