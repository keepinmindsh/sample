package basic.RegularExpression;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ExpressionSample {

    /**
     * ^[0-9]*$	숫자
     * ^[a-zA-Z]*$	영문자
     * ^[가-힣]*$	한글
     * \\w+@\\w+\\.\\w+(\\.\\w+)?	E-Mail
     * ^\d{2,3}-\d{3,4}-\d{4}$	전화번호
     * ^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$	휴대전화번호
     * \d{6} \- [1-4]\d{6}	주민등록번호
     * ^\d{3}-\d{2}$	우편번호
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        log.info("patternCheckForNumber Result : {}", patternCheckForNumber("123456789"));
        log.info("patternCheckForNumber Result : {}", patternCheckForNumber("123456789AA"));

        log.info("patternCheckToGetValue Result : {}", patternCheckToGetValue("123412341234sdfsadfasdf"));
        log.info("patternCheckToGetValue Result : {}", patternCheckToGetValue("dfsadfasdf"));

        log.info("patternCheckForValidate Result : {}", patternCheckForValidate("^[가-힣]*$", "홍길동"));
        log.info("patternCheckForValidate Result : {}", patternCheckForValidate("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", "010-1234-5678"));
        log.info("patternCheckForValidate Result : {}", patternCheckForValidate("\\w+@\\w+\\.\\w+(\\.\\w+)?", "test@naver.com"));
    }

    public static boolean patternCheckForNumber(String value){

        String pattern = "^[0-9]*$";

        return Pattern.matches(pattern, value);
    }

    public static boolean patternCheckToGetValue(String value){
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");

        Matcher matcher = pattern.matcher(value);

        return matcher.find();
    }

    public static boolean patternCheckForValidate(String pattern, String value){
        return Pattern.matches(pattern, value);
    }
}
