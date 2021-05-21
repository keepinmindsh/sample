package lines.algorithm.code6;

import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Code6 {

    public static void main(String[] args) {
       log.info("result : {}" , solution(5, new int[]{2,1,2,4,2,4,3,3}));

        log.info("result : {}" , solution(8, new int[]{1,2,3,4,5,6,7}));
    }

    private static int[] solution(int N, int[] stages) {
        Map<Integer, Integer> map = new HashMap<>();

        int stagesCnt = stages.length;

        for(int i = 0; i < N ; i ++){

            int failCnt = 0;
            int challangeCnt = 0;

            for(int j =0; j < stagesCnt ; j ++){
                if(stages[j] >= (i + 1)){
                    challangeCnt ++;
                }

                if(stages[j] == (i + 1)){
                    failCnt ++;
                }
            }

            map.put(i + 1, (int)Math.floor(((double)failCnt/(double)challangeCnt)*100));

            log.info("t1 value : {} - {}", i + 1, map.get(i+1));;
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());

        // 내림차순 //
        Collections.sort(keySetList, (t1, t2) -> {
            if(map.get(t2).compareTo(map.get(t1)) == 0){
                return t1.compareTo(t2);
            }else{
                return map.get(t2).compareTo(map.get(t1));
            }
        });


        int[] integers = new int[N];

        log.info("Array : {}", keySetList);

        for(int i = 0;i < N ; i ++){
            integers[i] = keySetList.get(i);
        }

        return integers;
    }
}
