package java8.basic05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSample02 {
    public static void main(String[] args) {
        Stream<String> builderStream = Stream.<String>builder()
                .add("Build1")
                .add("Build2")
                .add("Build3")
                .build();

        builderStream.map(item -> item + "Value").forEach(System.out::println);

        List<String> stringList = Arrays.asList("google", "google", "value" , "value1" , "value2" , "value3");

        Stream<String> stream1 = stringList.stream();
        Stream<String> stream2 = stream1.distinct();

        stream2.forEach(System.out::println);
    }
}
