package designpattern.gof_chainofresponsibility.sample01.Teran;

import designpattern.gof_chainofresponsibility.sample01.Unit.GroundUnit;
import designpattern.gof_chainofresponsibility.sample01.Unit.Unit;

public class Bunker extends Defense {

    private final String unitName;

    public Bunker(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public boolean defense(Unit unit) {
        System.out.println("----------------- Bunker --------------");

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
        if (unit instanceof GroundUnit) {
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
