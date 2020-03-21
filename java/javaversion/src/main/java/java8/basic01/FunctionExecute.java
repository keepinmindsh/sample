package java8.basic01;

import java.util.function.Function;

public class FunctionExecute {
    public static void main(String[] args) {
        Foo foo = value -> { return value + " 입니다."; };

        String value = foo.method("Value");

        System.out.println(value);

        Function<String, String> fooWithFunction = value2 -> { return value2 + " 입니다."; };

        String value2 = fooWithFunction.apply(value);

        System.out.println(value2);

        Foo foo1 = new Foo() {

            private String fooValue = "내부 변수";

            @Override
            public String method(String value) {
                return this.fooValue;
            }
        };

        String fooValue1 = foo1.method("");

        Foo foo2 = parameter -> {
            String fooValue = "람다변수";
          return fooValue;
        };

        String fooValue2 = foo2.method("");

        System.out.println("fooValue1"  + fooValue1 + ", fooValue2" + fooValue2);
    }
}
