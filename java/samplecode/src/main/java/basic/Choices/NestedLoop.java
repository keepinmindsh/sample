package basic.Choices;

public class NestedLoop {
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();

        for (int x = 1; x < 100; x++) {
            for (int y = 1; y < 10; y++) {
                if (x == y || (x % 10) == y) {
                    builder.append("0-0 ");
                } else {
                    builder.append(x + "-" + y + " ");
                }

            }
            builder.append("\r\n");
        }

        System.out.println(builder.toString());
    }
}
