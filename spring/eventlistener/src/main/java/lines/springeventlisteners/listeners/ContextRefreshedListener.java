package lines.springeventlisteners.listeners;

import lines.springeventlisteners.beans.EventHolderBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    private EventHolderBean eventHolderBean;

    @Autowired
    public void setEventHolderBean(EventHolderBean eventHolderBean){
        this.eventHolderBean = eventHolderBean;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("ContextRefreshedListener");

        this.eventHolderBean.setEventFired(true);
    }
}
