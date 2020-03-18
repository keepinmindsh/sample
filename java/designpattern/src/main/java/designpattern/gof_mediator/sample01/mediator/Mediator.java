package designpattern.gof_mediator.sample01.mediator;

import designpattern.gof_mediator.sample01.destination.IDestination;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    List<IDestination> list = new ArrayList<IDestination>();

    public void addDestination(IDestination destination){ list.add(destination); }

    public void onEvent(String from, String event){
        for(IDestination each : list){ // 이벤트의 전송
            each.receiveEvent(from, event);
        }
    }
}
