package pattern.sample.patternuse09.order;

import lombok.RequiredArgsConstructor;
import pattern.sample.patternuse09.order.inf.Training;
import pattern.sample.patternuse09.unit.inf.Unit;

@RequiredArgsConstructor
public class Watching  implements Training<Unit> {

    @Override
    public Unit practice(Unit unit) {
        unit.trainAbility(" 보기 능력이 추가되었습니다.");
        return unit;
    }
}
