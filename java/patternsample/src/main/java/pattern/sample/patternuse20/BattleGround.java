package pattern.sample.patternuse20;

import pattern.sample.patternuse20.property.WeaponProperty;
import pattern.sample.patternuse20.upgrade.GunUpgrade;
import pattern.sample.patternuse20.weapon.Gun;

public class BattleGround {
    public static void main(String[] args) {

        WeaponProperty weaponProperty = new Gun();

        weaponProperty.checkProperty();

        WeaponProperty weaponPropertyByUpgrade = new GunUpgrade(weaponProperty);

        weaponPropertyByUpgrade.checkProperty();
    }
}
