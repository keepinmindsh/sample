package designpattern.gof_chainofresponsibility.sample01.Unit;

public class AirUnit implements Unit {

    String unitName;

    public AirUnit(String unitNmae) {
        this.unitName = unitNmae;
    }

    public void Attack() {
        System.out.println("공중 유닛이 공격합니다.");
    }

    public String toString() {
        return unitName;
    }
}
