package basic.InnerClassSample;

public class InnnerClassSample01 {

    private String outerValue1 = "";
    private String outerValue2 = "";

    private void doOuterMethod() {
        System.out.println("나는 외부의 메소드입니다. ");

        System.out.println(outerValue1);
        System.out.println(outerValue2);
    }

    private class InnerClass {

        public void doSomething() {

            outerValue1 = "11";
            outerValue2 = "22";

            doOuterMethod();
        }

    }

    public void CalMethod() {
        InnerClass class1 = new InnerClass();

        class1.doSomething();

    }
}
