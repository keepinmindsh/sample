package pattern.sample.patternuse07.building;

import pattern.sample.patternuse07.unit.UnitComposite;

public class Barrack {
    public static UnitComposite requestUnit(){
        return new UnitComposite();
    }
}
