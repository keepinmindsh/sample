package basic.RandomProcess;

public class RandomProcess {

    public static void main(String[] args) {
        int rowCount = 100;

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= rowCount; i++) {
            builder.append(randomInt(1, 6));
            builder.append(" ");
            if (i % 5 == 0) {
                builder.append("\r\n");
            }
        }

        System.out.print(builder.toString());
    }

    public static int randomInt(int low, int high) {
        int result = (int) (Math.random() * (high - low + 1)) + low;

        return result;
    }
}
