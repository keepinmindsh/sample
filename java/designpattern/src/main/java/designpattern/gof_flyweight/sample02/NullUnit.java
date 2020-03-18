package designpattern.gof_flyweight.sample02;

public class NullUnit implements Unit {
    @Override
    public void getUnitName() {
        System.out.println("선택된 Unit이 없습니다.");
    }
}
