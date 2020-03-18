package designpattern.gof_observer.sample01.publisher;

import designpattern.gof_observer.sample01.subscriber.Observer;

public interface Publisher {
    public void add(Observer observer);

    public void delete(Observer observer);

    public void notifyObserver();
}
