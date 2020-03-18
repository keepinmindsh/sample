package designpattern.gof_observer.sample02;

import designpattern.gof_observer.sample02.publisher.Company;
import designpattern.gof_observer.sample02.subscriber.Subscriber;
import designpattern.gof_observer.sample02.subscriber.Subscriber2;

public class Messenger {

    public static void main(String[] args) {
        Company company = new Company(); //Subject 클래스를 생성합니다.
        Subscriber subscriber1 = new Subscriber(company); //Observer 클래스를 생성합니다.
        Subscriber2 subscriber2 = new Subscriber2(company); //Observer 클래스를 생성합니다.

        company.setMessage("photo", "이벤트"); //Subject에게 새로운 소식을 전달합니다.
    }
}
