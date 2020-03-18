package designpattern.gof_decorator.sample01;

public class Barrack {

    public static void main(String[] args) {
        Upgrade marinUpgrade = new MarineBasicUprade();

        marinUpgrade.upgrade();

        System.out.println("------------");

        Upgrade steampackUpgrade = new SteamPack(marinUpgrade);

        steampackUpgrade.upgrade();

        System.out.println("------------");

        Upgrade longRangeUpgrade = new LongRange(steampackUpgrade);

        longRangeUpgrade.upgrade();

        System.out.println("------------");

        Upgrade speedUpgrade = new Speed(longRangeUpgrade);

        speedUpgrade.upgrade();

        System.out.println("------------");

    }
}
