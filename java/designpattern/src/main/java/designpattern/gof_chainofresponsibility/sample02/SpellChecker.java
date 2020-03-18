package designpattern.gof_chainofresponsibility.sample02;

public class SpellChecker extends SystemChecker {

    @Override
    public boolean resolve(String type) {
        return type.equals("spell");
    }

    @Override
    public void done() {
        System.out.println("spell 체크가 성공하였습니다.");
    }
}
