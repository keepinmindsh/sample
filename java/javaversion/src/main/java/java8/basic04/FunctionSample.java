package java8.basic04;

public class FunctionSample {
    public static void main(String[] args) {
        System.out.println(callInteface((a , b ) -> a + b , 123,123));
    }

    public static int callInteface(CustomFuntionalInterface<Integer, Integer, Integer> customFuntionalInterface, int value1, int value2 ){
        return customFuntionalInterface.apply(value1, value2);
    }
}
