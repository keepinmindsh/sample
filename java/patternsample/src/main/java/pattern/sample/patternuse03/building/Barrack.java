package pattern.sample.patternuse03.building;

import pattern.sample.patternuse03.equipment.AttackingGloves;
import pattern.sample.patternuse03.equipment.CMCArmor;
import pattern.sample.patternuse03.equipment.HealGloves;
import pattern.sample.patternuse03.equipment.MedicArmor;
import pattern.sample.patternuse03.operation.Armed;
import pattern.sample.patternuse03.unit.Marine;
import pattern.sample.patternuse03.unit.Medic;

public class Barrack {

    public static Armed forMarine(){
        return new Armed(new Marine(new CMCArmor(), new AttackingGloves()));
    }

    public static Armed forMedic(){
        return new Armed(new Medic(new MedicArmor(), new HealGloves()));
    }
}
