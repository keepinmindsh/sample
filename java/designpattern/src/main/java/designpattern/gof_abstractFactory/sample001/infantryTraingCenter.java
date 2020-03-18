package designpattern.gof_abstractFactory.sample001;

public class infantryTraingCenter implements TrainingFactory {
    public Soldier create(String soldierType) {
        switch (soldierType) {
            case "marine":
                return new Marine();
            case "fire":
                return new Firebat();
        }
        // Null 을 쓰는 것은 좋지 않으나 패턴 설명을 위해 사용함.
        return null;
    }
}
