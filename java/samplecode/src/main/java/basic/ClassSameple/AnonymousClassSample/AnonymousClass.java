package basic.ClassSameple.AnonymousClassSample;

public class AnonymousClass {
    public static void main(String[] args) {
        Ball ball = new Ball() {
            public void hit() {
                System.out.println("You hit it!");
            }
        };

        ball.hit();
    }
}
