package designpattern.gof_observer.sample01.publisher;

import designpattern.gof_observer.sample01.subscriber.Observer;

import java.util.ArrayList;

public class NewsMachine implements Observable {

    private ArrayList<Observer> observers;
    private String title;
    private String news;

    public NewsMachine() {
        observers = new ArrayList<>();
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        int index = observers.indexOf(observer);
        observers.remove(index);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(title, news);
        }
    }

    public void setNewsInfo(String title, String news) {
        this.title = title;
        this.news = news;
        notifyObserver();
    }

    public String getTitle() {
        return title;
    }

    public String getNews() {
        return news;
    }
}
