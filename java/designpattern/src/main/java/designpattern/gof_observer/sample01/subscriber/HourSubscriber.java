package designpattern.gof_observer.sample01.subscriber;

import designpattern.gof_observer.sample01.publisher.Observable;

public class HourSubscriber implements Observer{
    private String newsString;
    private final Observable observable;

    public HourSubscriber(Observable observable) {
        this.observable = observable;
        observable.add(this);
    }

    @Override
    public void update(String title, String news) {
        newsString = title + "\n------------------------------------" + news;
        display();
    }

    public void display() {
        System.out.println("\n=== Hour 유저 ===");
        System.out.println("\n" + newsString);
    }

}
