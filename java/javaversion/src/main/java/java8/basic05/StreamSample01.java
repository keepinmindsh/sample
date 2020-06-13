package java8.basic05;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StreamSample01 {
    public static void main(String[] args) {
        List<Integer> listInteger = Stream.iterate(0, a -> a + 10).limit(10).collect(Collectors.toList());

        List<Integer> listInteger2 = listInteger.stream()
                .map(value -> value - 2)
                .peek(value -> System.out.println("테스트 1 : " + value) )
                .filter(value -> value > 0 )
                .peek(value -> System.out.println("테스트 2 : " + value) )
                .collect(Collectors.toList());

        listInteger2.forEach(value -> System.out.println("before filter ["+value+ "]"));

        System.out.println("");

        List<Integer> listInteger3 = listInteger2.stream()
                .skip(4)
                .collect(Collectors.toList());

        listInteger3.forEach(value -> System.out.println("after filter ["+value+ "]"));

        List<String> stringList = Stream.iterate(0, a -> a + 10).map(item -> item + " Value").limit(20).collect(Collectors.toList());

        Stream<String> sortedStream = stringList.stream().sorted(Comparator.comparing(String::length).reversed());

        sortedStream.forEach(s -> {
             log.info("Sorted Values : {}  ", s);
            });

        long count = stringList.stream().count();

        log.info("Count Value : {}" , count);

        String stringMin = stringList.stream().min(Comparator.comparing(String::valueOf)).get();

        log.info("min Value : {}" , stringMin);

        String stringMax = stringList.stream().max(Comparator.comparing(String::valueOf)).get();

        log.info("max Value : {}" , stringMax);

        List<Integer> longStream = Stream.iterate(0, a -> a + 1).limit(50).collect(Collectors.toList());

        Integer sum = longStream.stream().mapToInt(Integer::intValue).sum();

        log.info("총합계 {}", sum);

        OptionalDouble average = longStream.stream().mapToInt(Integer::intValue).average();

        log.info("Average Value : {}" , average.getAsDouble());

    }
}
