package pattern.sample.patternuse14.v1.weapon;

import lombok.RequiredArgsConstructor;
import pattern.sample.patternuse14.v1.weapon.inf.Weapon;
import pattern.sample.patternuse14.v2.weapon.NewWeapon;

@RequiredArgsConstructor
public class WeaponAdapter implements Weapon {

    private final NewWeapon newWeapon;

    @Override
    public void checkStatus() {
        newWeapon.checkStatus();
    }
}
