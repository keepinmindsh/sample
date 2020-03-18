package designpattern.gof_decorator.sample01;

public class MarineBasicUprade extends Upgrade {

    @Override
    public void upgrade() {
        System.out.println("공격력이 +1 증가하였습니다.");
    }
}
