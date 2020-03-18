package designpattern.gof_chainofresponsibility.sample02;

public class StringChecker extends SystemChecker {
    @Override
    public boolean resolve(String type) {
        return type.equals("string");
    }

    @Override
    public void done() {
        System.out.println("string 체크에 성공하였습니다.");
    }
}
