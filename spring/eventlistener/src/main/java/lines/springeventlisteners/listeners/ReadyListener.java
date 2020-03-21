package lines.springeventlisteners.listeners;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class ReadyListener {

    @EventListener(ApplicationReadyEvent.class)
    public void EventListenerExecute(){
        System.out.println("Application Ready Event");
    }
}
