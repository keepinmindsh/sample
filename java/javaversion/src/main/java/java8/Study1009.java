package java8;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class Study1009 {
    public static void main(String[] args) {
        // 형식 검사

        /**
         * 람다가 사용되는 콘텍스를 이용해서 람다의 형식을 추록할 수 있다. 어떤 콘텍스트에서 기대되는 람다 표현식의 형식을 대상 형식이라고 부른다.
         */

        // 대상 형식

        /**
         * 같은 람다 표현식이더라도 호환되는 추상 메서드를 가진 다른 함수형 인터페이스로 사용될 수 있다.
         */

        Callable<Integer> c = () -> 100;
        PrivilegedAction<Integer> p = () -> 100;

        // 형식 추론

        /**
         * 자바 컴파일러는 람다 표현식이 사용된 콘텍스트를 이용해서 람다 표현식과 관련된 함수형 인터페이스를 추론하다. 즉, 대상 형식을 이용해서 함수
         * 디스크립터를 알 수 있으므로 컴파일러는 람다의 시그너처도 추론할 수 있다.
         */

        // 지역 변수 사용

        /**
         * 람다 표현식에서는 익명함수가 하는 것 처럼 자유 변수(파라미터로 넘겨진 변수가 아닌 외부에서 정의된 변수 )를 활용할 수 있다. 이와 같은 동작을 람다 캡처링이라고 부른다.
         * 지역변수로 사용되려면 final과 같은 변수의 선언 및 동작 방식이 같아야한다.
         */

        int humanNUmber = 4500;
        Runnable r = () -> System.out.println(humanNUmber);

        // 지역 변수의 제약

        /**
         * 람다에서 지역 변수에 바로 접근할 수 있다는 가정 하에 람다가 스레드에서 실행된다면 변수를 할당한 스레드가 사라져서 변수 할당이 해제되었는데도 람다를 실행하는
         * 스레드에서는 해당 변수에 접근하려 할 수 있다. 따라서 자바 구현에서는 원래 변수에 접근을 허용하는 것이 아니라 자유 지역 변수의 복사본을 제공한다.
         */

        // 메서드 레퍼런스

        //Runnable a = () -> Human::getWeight

        /**
         * 메서드 레퍼런스는 특정 메서드만을 호출하는 람다의 축약형이라고 생각할 수 있다.
         * 명시적으로 메서드 명을 참조함으로써 가독성을 높일 수 있다.
         */

        /**
         * 정적 메서드 레퍼런스
         * 다양향 형식의 인터페이스 메서드 레퍼런스
         * 기존 책체의 인스턴스 메서드 레퍼런스
         */

        Function<String, Integer> stringToInteger = Integer::parseInt;

        // 생성자 레퍼런스
        Supplier<Human> c1 = Human::new;

        List<Integer> weights = Arrays.asList(7, 5, 3, 12);
        //List<Human> humans = map(weights, Human::new);


    }

    public static List<Human> map(List<Integer> list, Function<Integer, Human> f) {
        List<Human> humans = new ArrayList<>();
        for (Integer e : list
        ) {
            humans.add(f.apply(100));
        }
        return humans;
    }
}
