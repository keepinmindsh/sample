package lines.algorithm.code7;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Code7 {
    public static void main(String[] args) {
       log.info("result : {}",solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));


    }

    public static int[] solution(int[] array, int[][] commands) {

        int commmandSize = commands.length;
        int arraySize = array.length;


        int[] returnArray = new int[commmandSize];
        int arrayNumber = 0;
        int returnArrayNumber = 0;

        for(int i = 0;i < commmandSize; i ++){

            int start = commands[i][0];
            int end = commands[i][1];
            int position = commands[i][2];
            int[] answer = new int[end - start + 1];

            arrayNumber = 0;


            for(int j = 0; j < arraySize; j ++ ){
                int positionOfArray = j + 1;
                if(start <= positionOfArray && end >= positionOfArray ){
                    answer[arrayNumber] = array[j];

                    arrayNumber ++;
                }
            }

            Arrays.sort(answer);

            log.info("answer : {}", answer);

            int answerSize = answer.length;

            for(int j = 0; j < answerSize ; j ++){
                int positionOfAnswer = j + 1;
                if(position == positionOfAnswer ){
                    returnArray[returnArrayNumber] = answer[j];

                    returnArrayNumber ++;
                }
            }


        }



        return returnArray;
    }
}
