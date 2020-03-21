package basic.Choices;

public class ComparingStrings {
    public static void main(String[] args) {

        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();

        stringBuilder1.append("yes");
        stringBuilder2.append("yes");

        if (stringBuilder1.toString().equals(stringBuilder2.toString())) {
            System.out.println("두 개의 값은 같습니다.");
        }

        if (stringBuilder1.toString() == stringBuilder2.toString()) {
            System.out.println("두 개의 값은 같습니다.");
        }

    }
}
