package pattern.sample.patternuse09.building;

import pattern.sample.patternuse09.builder.TrainingBuilder;
import pattern.sample.patternuse09.code.UnitType;
import pattern.sample.patternuse09.order.*;
import pattern.sample.patternuse09.unit.Marine;
import pattern.sample.patternuse09.unit.Medic;
import pattern.sample.patternuse09.unit.inf.Unit;

public class Barrack {
    public static Unit getUnit(UnitType unitType){

        if(unitType == UnitType.MARINE){
            return TrainingBuilder
                    .builder()
                    .unit(new Marine())
                    .hiding(new Hiding())
                    .jumping(new Jumping())
                    .running(new Running())
                    .walking(new Walking())
                    .watching(new Watching())
                    .build().trainingUnit();
        }else{
            return TrainingBuilder
                    .builder()
                    .unit(new Medic())
                    .hiding(new Hiding())
                    .jumping(new Jumping())
                    .running(new Running())
                    .walking(new Walking())
                    .watching(new Watching())
                    .build().trainingUnit();
        }
    }
}
