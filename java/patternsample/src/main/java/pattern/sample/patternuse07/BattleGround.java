package pattern.sample.patternuse07;

import pattern.sample.patternuse07.building.Barrack;
import pattern.sample.patternuse07.unit.UnitComposite;
import pattern.sample.patternuse07.unit.type.MarineType;
import pattern.sample.patternuse07.unit.type.MedicType;

public class BattleGround {
    public static void main(String[] args) {
        UnitComposite unitList = Barrack.requestUnit();

        unitList.addTrainedUnit(new MedicType());
        unitList.addTrainedUnit(new MarineType());
        unitList.addTrainedUnit(new MarineType());
        unitList.addTrainedUnit(new MarineType());
        unitList.addTrainedUnit(new MarineType());
        unitList.addTrainedUnit(new MedicType());
        unitList.addTrainedUnit(new MedicType());
        unitList.addTrainedUnit(new MedicType());
        unitList.addTrainedUnit(new MedicType());

        unitList.trainingUnit();

        unitList.checkTrainedUnit();
    }
}
