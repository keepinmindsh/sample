package designpattern.gof_mediator.sample01.source;

import designpattern.gof_mediator.sample01.mediator.Mediator;

public class KoreanAir implements AirPlane {

    private Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void eventOccured(String event) {
        mediator.onEvent("System Signal", event);
    }
}
