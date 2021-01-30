package sample.Recursive;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecursiveSample {
    public static void main(String[] args) {

        int n = 10;
        long fact;
        fact = factorialByNonRecursive(n);

        log.info("1. Loop Count : {} , Factorial Count : {}" , n , fact);

        fact = factorialRecursice(n);
        log.info("2. Loop Count : {} , Factorial Count : {}" , n , fact);

    }

    private static long factorialByNonRecursive(int n){
        long f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    private static long factorialRecursice(int n){
        if ( n == 1){
            return 1;
        }else {
            return n * factorialRecursice(n -1 );
        }
    }


}
