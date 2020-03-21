package lines.springeventlisteners.listeners;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class StartListener {

    @EventListener(ApplicationStartedEvent.class)
    public void eventListenerStart(){
        System.out.println("Application Start Event");
    }
}
