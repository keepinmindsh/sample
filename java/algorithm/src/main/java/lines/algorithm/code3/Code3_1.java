package lines.algorithm.code3;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Code3_1 {

    public static void main(String[] args) {

      log.info("Not Completed User : {}", solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));

        log.info("Not Completed User : {}", solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }


    private static String solution(String[] participant, String[] completion) {

        String answer = "";
        int completionRows = completion.length;
        List<String> completionList = new ArrayList<>(Arrays.asList(completion));
        int participantRows = participant.length;


        for (int j = 0; j < participantRows; j++) {

            boolean isPass = true;

            for (int i = 0; i < completionRows; i++) {
                if (completionList.get(i).equals(participant[j])) {
                    isPass = false;
                    completionList.remove(i);
                    completionRows = completionList.size();
                    i = 0;
                    break;
                }
            }


            if(isPass){
                answer = participant[j];
                break;
            }
        }

        return answer;

    }

}
