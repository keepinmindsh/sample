package java8.basic05;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSample {
    public static void main(String[] args) {

        // https://12bme.tistory.com/461
        // https://12bme.tistory.com/468?category=682904
        // https://12bme.tistory.com/469?category=682904
        // https://jeong-pro.tistory.com/165
        // https://futurecreator.github.io/2018/08/26/java-8-streams/

        List<String> sampleList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "9", "10", "11");

        System.out.println("// --------------------------------------------------------------------------------------------------");

        List<String> resultList1 = sampleList.stream().filter(s -> s.equals("1")).collect(Collectors.toList());

        System.out.println(resultList1);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        Stream<String> resultList11 = sampleList.stream().filter(s -> s.equals("1")).peek(System.out::println);

        System.out.println(resultList11.findFirst());

        System.out.println("// --------------------------------------------------------------------------------------------------");

        List<String> resultList2 = sampleList.stream().distinct().collect(Collectors.toList());

        System.out.println(resultList2);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        List<String> resultList3 = sampleList.stream().limit(4).collect(Collectors.toList());  // Short Circuit Base

        System.out.println(resultList3);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        List<String> resultList4 = sampleList.stream().skip(3).collect(Collectors.toList());

        System.out.println(resultList4);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        List<String> resultList5 = sampleList.stream().map(s -> s + " 입니다").collect(Collectors.toList());

        System.out.println(resultList5);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        // .flatMap은 Array나 Object로 감싸져 있는 모든 원소를 단일 언소 스트림으로 반환해준다.
        // 스트림 평면화, 스트림의 각 값을 다른 스트림으로 만든 다음에 모든 스트림을 하나의 스트림으로 연결
        String[][] sample = new String[][]{
                {"a", "b"}, {"c", "d"}, {"e", "a"}, {"a", "h"}, {"i", "j"}
        };

        String[] words = new String[]{ "Hello World", "I will be a legendary" };

        Stream<String> stream = Arrays.stream(sample)
                .flatMap(Arrays::stream)
                .filter("a"::equals);

        List<String> wordList  = Arrays.stream(words).map(word -> word.split(""))
                                                            .flatMap(Arrays::stream)
                                                            .distinct()
                                                            .collect(Collectors.toList());

        stream.forEach(System.out::println);

        wordList.forEach(System.out::println);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        boolean resultBoolean = sampleList.stream().anyMatch(s -> s.equals("5")); // Short Circuit Base

        System.out.println(resultBoolean);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        boolean resultBoolean2  = sampleList.stream().allMatch(s -> s.equals("1")); // Short Circuit Base

        System.out.println(resultBoolean2);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        boolean resultBoolean3 = sampleList.stream().noneMatch(s -> s.equals("same?"));  // Short Circuit Base

        System.out.println(resultBoolean3);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        // https://www.daleseo.com/java8-optional-before/

        /**
         * null 은 쉽게 에러를 만들 수 있으므로 대신 사용
         * isPresent() : 값이 있는 가 여부
         * ifPresent(Consumer<T> block) : 값이 있으면 주어진 블록 실행
         */
        Optional<String> optional1 = sampleList.stream().findAny();

        System.out.println(optional1);

        sampleList.stream().filter(s -> s.compareTo("4") > 0 ).findAny().ifPresent(System.out::println);

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                sampleList.stream().filter(s -> s.compareTo("4") > 0 ).findAny().ifPresent(System.out::println);
            }
        });
        executorService.shutdown();

        System.out.println("// --------------------------------------------------------------------------------------------------");

        Publisher<Optional<String>> publisher = new Publisher<Optional<String>>(){

            @Override
            public void subscribe(Subscriber<? super Optional<String>> subscriber) {
                subscriber.onSubscribe(new Subscription() {

                    ExecutorService executorService = Executors.newFixedThreadPool(100);

                    @Override
                    public void request(long n) {

                        for (int i = 0; i < n ; i++) {
                            executorService.execute(new Runnable() {
                                @Override
                                public void run() {
                                    subscriber.onNext(sampleList.stream().findAny());
                                }
                            });
                        }

                        subscriber.onComplete();

                        executorService.shutdown();
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        Subscriber<Optional<String>> subscriber = new Subscriber<Optional<String>>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(100);
            }

            @Override
            public void onNext(Optional<String> s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println("완료하였습니다.");
            }
        };

        publisher.subscribe(subscriber);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        Optional<String> optional2 = sampleList.stream().skip(3).findFirst();

        System.out.println(optional2);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        Optional<String> concatenateWithString = sampleList.stream().reduce((a, b) -> a + b);

        System.out.println(concatenateWithString);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        String stringAdded = sampleList.stream().reduce("", (a, b ) -> a + b);

        System.out.println(stringAdded);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        List<Integer> intList = Arrays.asList( 1,2,3,4,5,6,7,8,9,10);

        Integer maxValue = intList.stream().reduce(0, Integer::max);

        System.out.println("최대 값은 " + maxValue);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        /**
         * 숫자 스트림
         *  박싱 비용을 피하기 위해서 제공됨.
         *  IntStream, DoubleStream, LongStream
         *  mapToInt
         *  max, min, average
         *  OptionalInt, OptionalDouble, OptionalLong
         */

        int[] intList2 = new int[100];

        Arrays.fill(intList2, 1, 100, 0);

        List<Map<Integer, Integer>> intMapList = new ArrayList<>();

        Arrays.stream(intList2).forEach(intValue -> {
           Map<Integer, Integer> mapIntValue = new HashMap<>();

           mapIntValue.put(intValue, intValue);

           intMapList.add(mapIntValue);
        });

        IntStream intStream = intMapList.stream().mapToInt(MapToIntValue::getIntFromMap);

        Stream<Integer> stream1 = intStream.boxed();

        System.out.println(stream1.findFirst());

        IntStream intStream2 = intMapList.stream().mapToInt(MapToIntValue::getIntFromMap);

        OptionalInt optionalInt = intStream2.max();

        optionalInt.ifPresent(System.out::println);
        
        System.out.println("// --------------------------------------------------------------------------------------------------");

        Stream.of("1", "1","1","1").forEach(System.out::println);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        int[] numberList = { 1,2,3,4,5,6,6};

        int value = Arrays.stream(numberList).sum();

        System.out.println("합은 " + value);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        try{
            Stream<String> line = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());

            long uniqueWords = line.flatMap(strValue -> Arrays.stream(strValue.split( " ")))
                    .distinct()
                    .count();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {

        }
        
        System.out.println("// --------------------------------------------------------------------------------------------------");

        Stream.iterate(0, n -> n + 100).limit(100).forEach(System.out::println);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        /*
            스트림연산의 상태
                내부 상태 없음
                stateless operation
                map, filter
                입력 스트림에서 각 요소를 받아 0 또는 결과를 출력 스트림으로 보내는 연산
            내부 상태 있음
                stateful operation
                reduce, sum, max
                결과를 누적할 내부 상태가 필요
                sorted, distinct 도 마찬가지
                요소를 정렬하거나 중복을 제거하려면 과거의 이력을 알고 있어야 함
                따라서 모든 요소가 버퍼에 추가되어 있어야 한다
                그래서 이러한 연산은 내부 상태를 갖는 연산
         */

        List<Integer> collectResultForList = Stream.iterate(0 , n -> n + 100).limit(100).collect(Collectors.toList());

        System.out.println(collectResultForList);

        Set<Integer> collectResultForSet = Stream.iterate(0, n -> n + 200).limit(200).collect(Collectors.toSet());

        System.out.println(collectResultForSet);

        Collection<Integer> collectionForCollection = Stream.iterate(0, n -> n + 300).limit(300).collect(Collectors.toCollection(ArrayList::new));

        System.out.println(collectionForCollection);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        List<Integer> resultList = Stream.iterate(0, n -> n + 1).limit(100).collect(Collectors.toList());

        long resultSum1 = resultList.stream().collect(Collectors.counting());
        long resultSum2 = resultList.stream().count();

        System.out.println("// --------------------------------------------------------------------------------------------------");

        long totalCalories = resultList.stream().collect(Collectors.summarizingInt(Food::getCalories)).getSum();

        System.out.println(totalCalories);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        String menuSum = resultList.stream().map(Food::getName).collect(Collectors.joining(","));

        System.out.println(menuSum);

        System.out.println("// --------------------------------------------------------------------------------------------------");

        // 그룹화 부터
    }

    static class Food {
        public static int getCalories(Integer integer){
            return integer + 1000;
        }

        public static String getName(Integer integer){
            return integer + "이름,";
        }
    }

    static class MapToIntValue {
        public static int getIntFromMap(Map<Integer, Integer> hashMap){
            System.out.println(hashMap);
            return hashMap.get(0);
        }
    }

}

