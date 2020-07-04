package pattern.sample.patternuse02;

import pattern.sample.patternuse02.building.inf.Constructor;
import pattern.sample.patternuse02.code.BuildType;
import pattern.sample.patternuse02.unit.creator.SCV;

public class BattleGround {
    public static void main(String[] args) {

        Constructor barrack1 = SCV.createBuilding(BuildType.BARRACK, 150, 0);

        Constructor factory1 = SCV.createBuilding(BuildType.FACTORY, 150, 150);

        barrack1.createBuilding();
        factory1.createBuilding();
    }
}
