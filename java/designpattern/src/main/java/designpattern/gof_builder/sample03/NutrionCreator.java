package designpattern.gof_builder.sample03;

public class NutrionCreator {

    public static void main(String[] args) {
        NutrionFacts.Builder builder = new NutrionFacts.Builder(20, 1);

        builder.calories(20).Build();
    }
}
