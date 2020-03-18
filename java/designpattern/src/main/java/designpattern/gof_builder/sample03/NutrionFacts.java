package designpattern.gof_builder.sample03;

public class NutrionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;

    public static class Builder {
        // 필수 인자
        private final int servingSize;
        private final int servings;
        private int calories;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public NutrionFacts Build() {
            return new NutrionFacts(this);
        }
    }

    private NutrionFacts(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
    }
}
