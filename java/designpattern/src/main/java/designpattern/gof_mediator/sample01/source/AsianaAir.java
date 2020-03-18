package designpattern.gof_mediator.sample01.source;

import designpattern.gof_mediator.sample01.mediator.Mediator;

public class AsianaAir implements AirPlane {

    private Mediator mediator;


    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void eventOccured(String event) {
        mediator.onEvent("AsianaAir", event);
    }
}
