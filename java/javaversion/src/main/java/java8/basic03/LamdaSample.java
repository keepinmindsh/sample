package java8.basic03;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LamdaSample {
    public static void main(String[] args) {

        getLengthOfString((String string) -> string.length(), "CheckLength");

        getCompareWeightWithApple((Apple apple) -> apple.getWeight() > 150, new Apple());

        getResultOfAdd( ( a, b ) -> a + b, 10, 20);
    }

    public static int getLengthOfString(Function<String, Integer> function, String targetString){
        return function.apply(targetString);
    }

    public static boolean getCompareWeightWithApple(Function<Apple, Boolean> function, Apple apple){
        return function.apply(apple);
    }

    static class Apple {

        int weight = 500;

        public int getWeight() {
            return weight;
        }
    }

    public static int getResultOfAdd(BiFunction<Integer, Integer, Integer> function, int value1, int value2){
        return function.apply(value1, value2);
    }
}
