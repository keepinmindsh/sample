package designpattern.gof_flyweight.sample02;

public class Ghost implements Unit {
    @Override
    public void getUnitName() {
        System.out.println("고스트 입니다");
    }
}
