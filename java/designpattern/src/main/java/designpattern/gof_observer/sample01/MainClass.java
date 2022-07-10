
package designpattern.gof_observer.sample01;

import designpattern.gof_observer.sample01.publisher.NewsMachine;
import designpattern.gof_observer.sample01.subscriber.AnnualSubscriber;
import designpattern.gof_observer.sample01.subscriber.EventSubscriber;
import designpattern.gof_observer.sample01.subscriber.HourSubscriber;

public class MainClass {
    public static void main(String[] args) {
        NewsMachine newsMachine = new NewsMachine();
        AnnualSubscriber annualSubscriber = new AnnualSubscriber(newsMachine);
        EventSubscriber eventSubscriber = new EventSubscriber(newsMachine);
        HourSubscriber hourSubscriber = new HourSubscriber(newsMachine);
        newsMachine.setNewsInfo("오늘 한파", "전국 영하 18도 입니다.");
        //newsMachine.setNewsInfo("벛꽃 축제합니다", "다같이 벚꽃보러~");
    }
}
