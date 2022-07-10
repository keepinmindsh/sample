package designpattern.gof_observer.sample01.subscriber;

import designpattern.gof_observer.sample01.publisher.Observable;

public class EventSubscriber implements Observer {
    private String newsString;
    private Observable observable;

    public EventSubscriber(Observable observable) {
        this.observable = observable;
        observable.add(this);
    }

    @Override
    public void update(String title, String news) {
        newsString = title + "\n------------------------------------" + news;
        display();
    }

    public void display() {
        System.out.println("\n=== 이벤트 유저 ===");
        System.out.println("\n" + newsString);
    }

}
