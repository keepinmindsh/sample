package pattern.sample.patternuse02.building.constructor;

import lombok.RequiredArgsConstructor;
import pattern.sample.patternuse02.building.inf.Building;
import pattern.sample.patternuse02.building.inf.Constructor;

@RequiredArgsConstructor
public class BuildingConstructor implements Constructor {

    private final int mineral;
    private final int gas;
    private final Building building;

    public Building createBuilding(){
        return building;
    }
}
