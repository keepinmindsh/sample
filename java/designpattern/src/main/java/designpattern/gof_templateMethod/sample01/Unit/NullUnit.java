package designpattern.gof_templateMethod.sample01.Unit;

public class NullUnit implements Unit {
    @Override
    public void unitName() {
        System.out.println("Null 입니다");
    }
}
