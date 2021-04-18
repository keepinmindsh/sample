package lines.algorithm.code3;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Code3 {

    public static void main(String[] args) {

      log.info("Not Completed User : {}", solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));

        log.info("Not Completed User : {}", solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    private static String solution(String[] participant, String[] completion) {
        String answer = "";

        int rowCount = participant.length;

        List<String> StringList = new ArrayList(Arrays.asList(completion));



        for (int i = 0; i < rowCount; i++) {
            String value = participant[i];
            if(!StringList.contains(value)){
                answer = participant[i];
                break;
            }else{
                if(StringList.isEmpty()) break;
                StringList.remove(value);
            }
        }

        return answer;

    }
}
