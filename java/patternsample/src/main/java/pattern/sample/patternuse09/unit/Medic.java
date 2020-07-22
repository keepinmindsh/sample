package pattern.sample.patternuse09.unit;

import pattern.sample.patternuse09.unit.inf.Unit;

public class Medic implements Unit {

    private StringBuilder abilities = new StringBuilder();
    private final String unitName;

    public Medic(){
        unitName = "Medic";
    }

    public void trainAbility(String ability){
        abilities.append("능력 : " + ability + "\r\n");
    }

    public String checkAbility(){
        return abilities.toString();
    }
}
