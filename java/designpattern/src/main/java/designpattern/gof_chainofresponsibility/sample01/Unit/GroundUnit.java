package designpattern.gof_chainofresponsibility.sample01.Unit;

public class GroundUnit implements Unit {

    String unitName;

    public GroundUnit(String unitName) {
        this.unitName = unitName;
    }

    public void Attack() {
        System.out.println("지상 유닛이 공격합니다.");
    }

    public String toString() {
        return unitName;
    }
}
