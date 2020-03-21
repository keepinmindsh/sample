package java8.basic05;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSample01 {
    public static void main(String[] args) {
        List<Integer> listInteger = Stream.iterate(0, a -> a + 10).limit(10).collect(Collectors.toList());

        List<Integer> listInteger2 = listInteger.stream().map(value -> value - 2).peek(value -> System.out.println("테스트 : " + value) ).filter(value -> value > 0 ).peek(value -> System.out.println("테스트 : " + value) ).collect(Collectors.toList());

        listInteger2.forEach(value -> System.out.print("["+value+ "]"));

        System.out.println("");

        List<Integer> listInteger3 = listInteger2.stream().skip(4).collect(Collectors.toList());

        listInteger3.forEach(value -> System.out.print("["+value+ "]"));

    }
}
