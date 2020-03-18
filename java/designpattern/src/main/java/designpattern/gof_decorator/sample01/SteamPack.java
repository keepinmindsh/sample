package designpattern.gof_decorator.sample01;

public class SteamPack extends UpgradeDecorator {
    public SteamPack(Upgrade upgrade) {
        super(upgrade);
    }

    @Override
    public void upgrade() {
        super.upgrade();

        applySteamPack();
    }

    public void applySteamPack() {
        System.out.println("스팀팩이 적용되었습니다. ");
    }
}
