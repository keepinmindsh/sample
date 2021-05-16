package lines.algorithm.code5;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Code5 {
    public static void main(String[] args) {
        int result = solution(new int[]{3,1,2,3});

        log.info("Result : {} ", result);
    }

    private static int solution(int[] nums) {
        int answer = 0;

        int numSize = nums.length;

        for(int i = 0; i < numSize ; i ++){

            if(nums[i] != 0){
                int selectedValue = nums[i];
                for(int j = i + 1; j < numSize ; j ++){
                    if(selectedValue == nums[j]){
                        nums[j] = 0;
                    }
                }
            }
        }

        int half = numSize / 2;

        for(int i = 0; i < numSize; i ++){
            if(answer == half){
                break;
            }else{

                if(nums[i] != 0){
                    answer ++;
                }
            }
        }

        return answer;
    }
}
