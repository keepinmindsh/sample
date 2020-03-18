package designpattern.gof_mediator.sample01.destination;

public class Log implements IDestination {
    public void receiveEvent(String from, String event) {
        System.out.println("Log : From " + from + " event : " + event);
    }
}
