package designpattern.gof_decorator.sample01;

public abstract class UpgradeDecorator extends Upgrade {

    protected Upgrade upgrade;

    public UpgradeDecorator(Upgrade upgrade) {
        this.upgrade = upgrade;
    }

    public void upgrade() {
        upgrade.upgrade();
    }
}
