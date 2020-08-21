package pattern.sample.patternuse14;

import pattern.sample.patternuse14.v1.weapon.WeaponAdapter;
import pattern.sample.patternuse14.v1.weapon.inf.Weapon;
import pattern.sample.patternuse14.v2.weapon.SpeedGun;

public class Barrack {
    public static void main(String[] args)
    {
        Weapon weapon = new WeaponAdapter(new SpeedGun());

        weapon.checkStatus();
    }
}
