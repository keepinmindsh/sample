package pattern.sample.patternuse11;

import pattern.sample.patternuse11.building.Barrack;
import pattern.sample.patternuse11.unit.Marine;
import pattern.sample.patternuse11.unit.Medic;

import java.util.Arrays;

public class BattleGround {
    public static void main(String[] args) {

        Barrack barrack = new Barrack();

        barrack.isTrainedUnit(new Marine());

        barrack.isTrainedUnit(Arrays.asList(new Marine(), new Medic()));
    }
}
