package designpattern.gof_mediator.sample01.source;

import designpattern.gof_mediator.sample01.mediator.Mediator;

public interface AirPlane {
    public void setMediator(Mediator mediator);
    public void eventOccured(String event);
}
