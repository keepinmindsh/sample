package lines.algorithm.code4;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Code4 {

    public static void main(String[] args) {


        log.info("Result : {}", solution(new int[]{ 5, 9, 7, 10 }, 5));

    }

    public static int[] solution(int[] arr, int divisor) {
        List<Integer> integerList = new ArrayList<>();
        int rowSize = arr.length;

        if (divisor != 1) {
            for (int i = 0; i < rowSize; i++) {
                if (arr[i] % divisor == 0) {
                    integerList.add(arr[i]);
                }
            }

            if (integerList.size() == 0) {
                return new int[]{-1};
            } else {
                return sort(toIntArray(integerList));
            }
        } else {
            return sort(arr);
        }
    }

    private static int[] toIntArray(List<Integer> integerList){

        int[] array = new int[integerList.size()];

        int size=0;

        for(Integer temp : integerList){
            array[size++] = temp;
        }

        return array;
    }

    private static int[] sort(int[] arr) {
        //sorting logic
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                int tmp = 0;
                if (arr[i] > arr[j])
                {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }
}
