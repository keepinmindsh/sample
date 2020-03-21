package basic.EffectiveJava.ForEachSamples;

public class IterableSample {
    public static void main(String[] args) {

        Suit<String> suits = new Suit<>();

        suits.add("정장1");
        suits.add("정장2");
        suits.add("정장3");
        suits.add("정장4");

        for (String clothName : suits) {
            System.out.println(clothName);
        }
    }
}
