package basic.ClassSameple.Initializer;

import java.util.Scanner;

public class PrimeClass {

    private Scanner sc = new Scanner(System.in);

    public int x;

    // 해당 클래스가 생성될 때 값을 초기화 할 수 있는 방식
    {
        System.out.println("Enter the starting value for x : ");
        x = sc.nextInt();
    }


    public int getX() {
        return x;
    }
}
