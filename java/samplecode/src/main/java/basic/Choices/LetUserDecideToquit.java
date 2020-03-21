package basic.Choices;

import java.util.Scanner;

public class LetUserDecideToquit {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int number = 2;
        String input;

        while (true) {
            System.out.println(number + " ");
            System.out.println("Do you want to keep counting ( Y or N ) ?");
            input = sc.next();
            if (input.equalsIgnoreCase("N")) {
                break;
            }
            number += 2;
        }
        System.out.println("\n Whew! That was close!, \n");
    }
}
