package pattern.sample.patternuse20.upgrade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse20.property.WeaponProperty;

@RequiredArgsConstructor
@Slf4j
public class GunUpgrade implements WeaponProperty {

    private final WeaponProperty weaponProperty;

    @Override
    public void checkProperty() {
        weaponProperty.checkProperty();

        applyAdditionalProperty();
    }

    public void applyAdditionalProperty(){
        log.info("공격력이 업그레이드 되었습니다. 공격력 : 10 + 5 ");
    }
}
