package designpattern.gof_observer.sample01.subscriber;

import designpattern.gof_observer.sample01.publisher.Observable;

public class AnnualSubscriber implements Observer {
    private String newsString;
    private Observable observable;

    public AnnualSubscriber(Observable observable) {
        this.observable = observable;
        observable.add(this);
    }

    @Override
    public void update(String title, String news) {
        this.newsString = title + " \n -------- " + news;
        display();
    }

    private void display() {
        System.out.println("\n오늘의 뉴스\n============================\n" + newsString);
    }
}
