package pattern.sample.patternuse18;

import org.reactivestreams.Publisher;
import pattern.sample.patternuse18.order.Mouse;
import pattern.sample.patternuse18.sub.Action;
import pattern.sample.patternuse18.unit.Unit;
import pattern.sample.patternuse18.unit.impl.Marine;

import java.util.ArrayList;
import java.util.List;

public class BattleGround {
    public static void main(String[] args) {

        List<Unit> unitList = new ArrayList<>();

        unitList.add(new Marine());
        unitList.add(new Marine());
        unitList.add(new Marine());
        unitList.add(new Marine());
        unitList.add(new Marine());
        unitList.add(new Marine());
        unitList.add(new Marine());
        unitList.add(new Marine());
        unitList.add(new Marine());
        unitList.add(new Marine());
        unitList.add(new Marine());

        Publisher publisher = new Mouse(unitList);

        publisher.subscribe(new Action());
    }
}
