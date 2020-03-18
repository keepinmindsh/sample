package designpattern.gof_composite.sample002;

public class Client {

    public static void main(String[] args) {

        // 각각의 세부 객체 - 각각의 역할에 따라 다르게 처리됨
        Component leaf1 = new Leaf1();
        Component leaf2 = new Leaf2();
        Component leaf3 = new Leaf3();
        Component leaf4 = new Leaf4();

        Component composite = new Composite();

        // 복합체에 각각의 고유 프로세스 객체를 담는다.
        composite.Add(leaf1);
        composite.Add(leaf2);
        composite.Add(leaf3);
        composite.Add(leaf4);

        // 복합체의 실행
        composite.Operation();
    }
}
