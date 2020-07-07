package pattern.sample.patternuse03;

import pattern.sample.patternuse03.building.Barrack;
import pattern.sample.patternuse03.operation.Armed;

public class BattleGround {
    public static void main(String[] args) {
        Armed armedMarine = Barrack.forMarine();

        Armed armedMedic = Barrack.forMedic();
    }
}
