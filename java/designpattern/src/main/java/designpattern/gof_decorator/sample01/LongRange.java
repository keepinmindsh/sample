package designpattern.gof_decorator.sample01;

public class LongRange extends UpgradeDecorator {
    public LongRange(Upgrade upgrade) {
        super(upgrade);
    }

    @Override
    public void upgrade() {
        super.upgrade();

        applyLongRange();
    }

    public void applyLongRange() {
        System.out.println("공격 사거리가 10 증가하였습니다.");
    }
}
