package designpattern.gof_mediator.sample01;

import designpattern.gof_mediator.sample01.destination.AirRoad;
import designpattern.gof_mediator.sample01.mediator.Mediator;
import designpattern.gof_mediator.sample01.source.AirPlane;
import designpattern.gof_mediator.sample01.source.AsianaAir;
import designpattern.gof_mediator.sample01.source.KoreanAir;

public class ControllerMain {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        AirPlane asianaAir = new AsianaAir();

        asianaAir.setMediator(mediator);

        AirPlane koreanAir = new KoreanAir();

        koreanAir.setMediator(mediator);

        mediator.addDestination(new AirRoad());

        asianaAir.eventOccured("connected");
        asianaAir.eventOccured("disconnected");

        System.out.println("-------------------");

        koreanAir.eventOccured("key input");
        koreanAir.eventOccured("mouse input");
    }
}
