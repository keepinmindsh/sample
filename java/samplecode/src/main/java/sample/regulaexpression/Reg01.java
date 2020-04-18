package sample.regulaexpression;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Reg01 {
    static String r, s;
    static Pattern pattern;
    static Matcher matcher;
    static boolean match, validRegex, doneMatching;
    private static Scanner scanner = new Scanner(System.in);

    /*
        f[aio]r - fir, for
        c.t - cat, cot (O) , cart (X)
        \d\d\d-\d\d-\d\d\d\d - 779-54-3994 (O), 550-403-004 (X)
        \D\d-\D\d - R2-D2, C2-D0 (O), C-3PO (X)
        ...\s... - abc def , abc      def (O)
        ...  ... - abc  def (O), abc     def (X)
        \w\w\w\W\w\w\w - abc def , 123 456 (O), 123_456 (X)
        b[aeiou]t - bat, bet, bit, bot, but (O), bmt (X)
        b[aAeEiIoOuU]t - bat , bAt (O), BAT (X)
        [bB][aAeEiIoOuU][tT] - bat (O), BAT (X)
        [a-z][0-5] - r2 (O), b9 (X)
        [a-zA-Z][0-5] - r2, R2 (O)
        [a-zA-Z0-9] - a , N , 9 (O)
        [^cf]at - bat (O), cat, fat (X)
        \d{3}-\d{2}-\d{4} - 779-48-9995 (O), 483-488-9944 (X)
        Quantifier :
           ? - Zero Times or one time
           * - Zero or more times
           + - One or more times
           {n} - Exactly n times
           {n,} - At least n times
           {n,m} - At least n times but no more then m times
        \d{3}-?\d{2}-?\d{4} - 779-48-9955, 779489955, 779-489955 (O) , 77948995 (X)
        \(\d{3}\) \d{3}-\d{4} - (559) 555-1234 (O), 559 555-1234 (X)
        (bla)+ - bla , blabla , blablabla (O), bla bla bla (X)
        (\(\d{3}\)\s?)?\d{3}-\d{4} - 555-1234, (559) 555-1234 (O), (559)555-1239
        \w(\d)-\w\1 - r2-d2 , b9-k9 (O) , d3-r4 (X)
        (\w\d-\w\d)|(\w-\d\w\w) - r2-d2 , c-3po (O)
        ((\d{3} )|(\(\d{3}\) ))?\d{3}-\d{4} - (559) 55-1234 , 559 555-1234 , 555-1234

     */


    public static void main(String[] args) {


        String s = "One:Two;Three|Four\tFive";
        String regex = "[:;|\\t]";
        String strings[] = s.split(regex);
        for(String word : strings)
            log.info(word);


        log.info("Welcome to the Regex Tester\n");
        do{
            do{
                log.info("\n Enter regex :    ");
                r = scanner.nextLine();
                validRegex = true;
                try{
                    pattern = Pattern.compile(r);
                }catch(Exception exception){
                    log.info(exception.getMessage());
                    validRegex = false;
                }
            }while (!validRegex);

            doneMatching = false;

            while (!doneMatching){
                log.info("Enter String : ");
                s = scanner.nextLine();
                if(s.length() == 0){
                    doneMatching = true;
                }else{
                    log.info("Enter String : ");
                    s = scanner.nextLine();
                    if(s.length() == 0){
                        doneMatching = true;
                    }else{
                        matcher = pattern.matcher(s);
                        if(matcher.matches()){
                            log.info("Match. ");
                        }else{
                            log.info("Does not match.");
                        }
                    }
                }
            }
        }while (askAgain());
    }
    private static boolean askAgain(){
        log.info("Another ? ( Y or N ) ");
        String reply = scanner.nextLine();
        if(reply.equalsIgnoreCase("Y")){
            return true;
        }
        return false;
    }
}
