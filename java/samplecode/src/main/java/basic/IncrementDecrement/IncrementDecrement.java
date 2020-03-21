package basic.IncrementDecrement;

public class IncrementDecrement {

    public static void main(String[] args) {

        int a = 5;
        int b = 3;

        int c = a * ++b;

        System.out.println(c);

        b = 3;

        int d = a * b++;

        System.out.println(d);

        b = 3;

        int e = a + b++;

        System.out.println(e);

        b = 3;

        int f = a + ++b;

        System.out.println(f);

    }
}
