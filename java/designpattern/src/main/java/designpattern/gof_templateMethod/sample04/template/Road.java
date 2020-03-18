package designpattern.gof_templateMethod.sample04.template;

public class Road {

    public static void main(String[] args) {

        Action seungHwa = new Push(new ATM());

        seungHwa.execute();
    }
}
