package pattern.sample.patternuse02.unit.creator;

import pattern.sample.patternuse02.building.Barrack;
import pattern.sample.patternuse02.building.constructor.BuildingConstructor;
import pattern.sample.patternuse02.building.Factory;
import pattern.sample.patternuse02.code.BuildType;

public class SCV {
    public static BuildingConstructor createBuilding(BuildType buildType, int mineral, int gas){
        switch (buildType){
            case BARRACK:
                return new BuildingConstructor(mineral, gas, new Barrack());
            case FACTORY:
                return new BuildingConstructor(mineral, gas, new Factory());
            default:
                return null;
        }
    }
}
