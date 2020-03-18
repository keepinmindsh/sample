package designpattern.gof_mediator.sample01.destination;

public class AirRoad implements IDestination {
    public void receiveEvent(String from, String event) {
        System.out.println("AirRoad : from " + from + " event : " + event);

        try {
            Thread.sleep(1500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
