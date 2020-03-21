package java8.basic02;

import java.util.Comparator;
import java.util.function.*;

public class FunctionalInterfaceList {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("value");

        runnable.run();

        Supplier<String> supplier = () -> "Hello Supplier";

        String get = supplier.get();

        System.out.println(get);

        Consumer<? super Object> consumer = System.out::println;

        consumer.accept("테스트 함수");

        Function<String, Integer> function = Integer::parseInt;

        Integer result = function.apply("123123");

        consumer.accept(result);

        Predicate<String> predicate = String::isEmpty;

        boolean isRight = predicate.test("");

        consumer.accept(isRight);

        UnaryOperator<String> unaryOperator = str -> str + "isEmpty";

        String unaryValue = unaryOperator.apply("haha");

        consumer.accept(unaryValue);

        BinaryOperator<String> binaryOperator = (str1 , str2) -> str1 +  str2;

        consumer.accept(binaryOperator.apply("asdf", "asdfsa"));

        BiPredicate<String, Integer> biPredicate = (str, num) -> str.equals(Integer.toString(num));

        consumer.accept(biPredicate.test("adfsafd", 31231));

        BiConsumer<String, Integer> biConsumer = (str, num) -> System.out.println(str + "::" + num);

        biConsumer.accept("숫자", 40);

        BiFunction<Integer, String, String> biFunction = (num, str) -> String.valueOf(num) + str;

        String biFunctionResult = biFunction.apply(50, "678");

        consumer.accept(biFunctionResult);

        Comparator<String> comparator = String::compareTo;

        consumer.accept(comparator.compare("123123","123123"));

        // https://multifrontgarden.tistory.com/128?category=471239
    }
}
