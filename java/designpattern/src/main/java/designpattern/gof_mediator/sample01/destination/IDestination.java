package designpattern.gof_mediator.sample01.destination;

public interface IDestination {
    public void receiveEvent(String from, String event);
}
