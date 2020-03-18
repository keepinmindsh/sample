package designpattern.gof_chainofresponsibility.sample01.Teran;

import designpattern.gof_chainofresponsibility.sample01.Unit.AirUnit;
import designpattern.gof_chainofresponsibility.sample01.Unit.Unit;

public class MissileTurret extends Defense {

    private final String unitName;

    public MissileTurret(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public boolean defense(Unit unit) {
        System.out.println("----------------- Missile Turret 1 --------------");

        boolean isSurvive = tryToDefense(unit);

        if (isSurvive) {
            System.out.println("적의 공격을 방어했습니다.");
        } else {
            System.out.println(getBuildingName() + "가 파괴되었습니다.");
        }

        return isSurvive;
    }

    @Override
    public boolean tryToDefense(Unit unit) {
        if (unit instanceof AirUnit) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getBuildingName() {
        return unitName;
    }
}
