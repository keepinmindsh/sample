package pattern.sample.patternuse09;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse09.building.Barrack;
import pattern.sample.patternuse09.code.UnitType;
import pattern.sample.patternuse09.unit.inf.Unit;

@Slf4j
public class BattleGround {
    public static void main(String[] args) {
        Unit unit = Barrack.getUnit(UnitType.MARINE);

        Unit unitMedic = Barrack.getUnit(UnitType.MEDIC);

        log.info("결과 : {}" ,unit.checkAbility());
        log.info("결과 : {}" ,unitMedic.checkAbility());
    }
}
