package basic.Choices;

public class CountDownLoop {
    public static void main(String[] args) {
        System.out.println("we are go for launch in T minus");

        for (int count = 10; count >= 0; count--) {
            if (count == 8) {
                System.out.println("Ignition sequence start!");
            } else {
                System.out.println(count + "...");
            }
        }
        System.out.println("All engines running!");
        System.out.println("Liftoff! We have a liftoff!");
    }
}
