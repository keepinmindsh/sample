package lines.algorithm.code1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class Code1 {
    public static void main(String[] args) {

        int[] valueList = {2, 1, 3, 4, 1};

        log.info("Log Info : {}", solution(valueList));
    }

    public static int[] solution(int[] numbers) {
        List<Integer> intArray = new ArrayList<>();
        int rows = numbers.length;

        for (int i = 0; i < rows; i++) {
            int value = numbers[i];
            for (int j = 0; j < rows; j++) {
                if (j != i) {
                    int sumValue = value + numbers[j];
                    if (!intArray.contains(sumValue)) {
                        intArray.add(sumValue);
                    }
                }
            }
        }

        intArray.sort(Comparator.naturalOrder());

        return convertIntegers(intArray);
    }

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}
