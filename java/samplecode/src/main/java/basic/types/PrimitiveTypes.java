package basic.types;

public class PrimitiveTypes {
    public static void main(String[] args) {
        int values = 0;
        boolean boolValues = false;

        String stringValues = null;

        int i = 20;
        int j = 20;

        if (i == j) {
            System.out.println("i and j are equal");
        }

        String JPY = new String("JPY");
        String YEN = new String("JPY");

        if (JPY == YEN) {
            System.out.println("JPY and YEN are same");
        }

        if (JPY.equals(YEN)) {
            System.out.println("JPY and YEN are equal by equals()");
        }
    }
}
