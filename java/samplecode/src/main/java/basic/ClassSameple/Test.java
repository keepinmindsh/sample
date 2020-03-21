package basic.ClassSameple;

import basic.ClassSameple.Initializer.PrimeClass;
import basic.ClassSameple.ProtectedValue.ProtectedValueTest;

public class Test {
    public static void main(String[] args) {
        ProtectedValueTest test = new ProtectedValueTest();
        test.valueTest3 = "111";

        PrimeClass primeClass = new PrimeClass();

        System.out.println(primeClass.getX());
    }
}
