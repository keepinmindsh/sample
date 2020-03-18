package designpattern.gof_decorator.sample01;

public class Speed extends UpgradeDecorator {

    public Speed(Upgrade upgrade) {
        super(upgrade);
    }

    public void upgrade() {
        super.upgrade();

        applySteamUpgrade();
    }

    public void applySteamUpgrade() {
        System.out.println("속도가 10 만큼 증가하였습니다.");
    }
}
