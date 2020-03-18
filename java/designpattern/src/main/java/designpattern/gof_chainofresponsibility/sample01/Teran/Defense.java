package designpattern.gof_chainofresponsibility.sample01.Teran;

import designpattern.gof_chainofresponsibility.sample01.Unit.Unit;

import java.util.ArrayList;
import java.util.List;

public abstract class Defense {

    protected List<Defense> defense = new ArrayList<>();

    public void setDifense(Defense defense){
        this.defense.add(defense);
    }

    public final void attackCommand(Unit unit){
        for (Defense defense: defense ) {
           if(defense.attackByUnit(unit)){
               return;
           }
        }
    }


    public final boolean attackByUnit(Unit unit){
        System.out.println(unit.toString() + " ------------------- Battle Start -------------------");
        System.out.println();
        if (defense(unit)) {
            System.out.println(unit.toString() + " 의 방어에 성공했습니다.");
            System.out.println();
            System.out.println(unit.toString() +  " -------------------- Battle End ---------------------");
            return true;
        }else {
            System.out.println(unit.toString() + " 의 방어에 실패했습니다.");
            System.out.println();
            System.out.println(unit.toString() +  " -------------------- Battle End ---------------------");
            return false;
        }
    }

    public abstract boolean defense(Unit unit);

    public abstract boolean tryToDefense(Unit unit);

    public abstract String getBuildingName();
}
