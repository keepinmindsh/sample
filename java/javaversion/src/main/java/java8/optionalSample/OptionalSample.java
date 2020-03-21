package java8.optionalSample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalSample {

    public static void main(String[] args) {

        Map<String, String> testMap = new HashMap<>();

        testMap.put("test1", "1번 테스트 데이터");
        testMap.put("test2", "2번 테스트 데이터");
        testMap.put("test3", "3번 테스트 데이터");

        Optional<String> testData = Optional.ofNullable(testMap.get("test4"));

        if(testData.isPresent()){
            System.out.println(testData.get());
        }else{
            System.out.println("데이터가 없어요!");
        }

        int length = testData.map(String::length).orElse(0);
        System.out.println("length: " + length);

        List<Integer> listData = Stream.of(1,2,3,4,5,7,8,9,10).collect(Collectors.toList());
        Optional<Integer> optionalValue =  getAsOptional(listData, 30);
        int intValue = optionalValue.map( integer ->  integer + 1 ).orElse(0);
        System.out.println(intValue);

        List<Integer> listData2 = Stream.iterate(0, i -> i +1).limit(10).collect(Collectors.toList());
        Optional<Integer> optionalValue2 =  getAsOptional(listData, 32);
        optionalValue2.ifPresent(value -> {
            System.out.println("값을 출력하세요~!" + value);
        });

        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("put", "value");

        Optional<Map> valueMap = getMapData(paramMap, "get");

        valueMap.ifPresent(
            map -> System.out.println(map.toString())
        );
    }

    public static <T> Optional<T> getAsOptional(List<T> list, int index) {
        try {
            return Optional.of(list.get(index));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public static Optional<Map> getMapData(Map mapdata, String key){
        return Optional.ofNullable(mapdata)
                .filter(map -> map.get(key) == "Value1")
                .map(Converter::converter);
    }
}

class Converter {
    public static Map converter(Map mapdata){
        return mapdata;
    }
}
