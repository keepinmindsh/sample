package lines.algorithm.code3;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Code3_3 {

    public static void main(String[] args) {
        log.info("Not Completed User : {}", solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        log.info("Not Completed User : {}", solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    private static String solution(String[] participant, String[] completion) {

        String answer = "";
        int completionRows = completion.length;
        int participantRows = participant.length;

        Map<String, Integer> hashList = new HashMap<>();

        for (int j = 0; j < participantRows; j++) {
            if(hashList.containsKey(participant[j])){
                hashList.put(participant[j], hashList.get(participant[j])+1);
            } else {
                hashList.put(participant[j], 1);
            }
        }

        for (int i = 0; i < completionRows; i++) {
            hashList.put(completion[i],hashList.get(completion[i]) -1 );
        }

        for (String value : participant) {
            if(hashList.get(value) != 0){
                answer = value;
                break;
            }
        }

        return answer;

    }

}
