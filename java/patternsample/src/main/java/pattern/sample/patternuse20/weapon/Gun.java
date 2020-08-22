package pattern.sample.patternuse20.weapon;

import lombok.extern.slf4j.Slf4j;
import pattern.sample.patternuse20.property.WeaponProperty;

@Slf4j
public class Gun implements WeaponProperty {
    @Override
    public void checkProperty() {
        log.info("기본 설정 값이 세팅되었습니다. 공격력 : 10");
    }
}
