package pattern.sample.patternuse09.builder;

import lombok.Builder;
import pattern.sample.patternuse09.order.inf.Training;
import pattern.sample.patternuse09.unit.inf.Unit;

@Builder
public class TrainingBuilder {
    private final Training walking;
    private final Training running;
    private final Training jumping;
    private final Training hiding;
    private final Training watching;
    private final Unit unit;

    public Unit trainingUnit(){

        walking.practice(unit);

        running.practice(unit);

        jumping.practice(unit);

        hiding.practice(unit);

        watching.practice(unit);

        return unit;
    }
}
