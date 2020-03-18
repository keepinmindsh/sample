package designpattern.gof_observer.sample02.subscriber;

import designpattern.gof_observer.sample02.publisher.Company;

import java.util.Observable;
import java.util.Observer;

public class Subscriber2 implements Observer, DisplayElement {
    private Observable observable;
    private String photoUrl;
    private String content;

    public Subscriber2(Observable observable) {

        this.observable = observable;
        observable.addObserver(this); // 옵저버로 등록한다.
    }

    @Override
    public void display() { // 받은 소식을 화면에 나타내어주는 메소드
        // TODO Auto-generated method stub
        System.out.println("2번째 구독자");
        System.out.println("photo link : " + photoUrl);
        System.out.println("content : " + content);
        System.out.println("\n");
    }

    @Override
    public void update(Observable obs, Object args) { // 새로운 소식을 받는 메소드
        // TODO Auto-generated method stub

        if (obs instanceof Company) {
            Company company = (Company) obs;

            this.photoUrl = company.getPhotoUrl();
            this.content = company.getContent();
            display();
        }

    }
}
