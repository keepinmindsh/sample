package lines.springeventlisteners.listeners;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class ContextPreparedListener {

    @EventListener(ApplicationEnvironmentPreparedEvent.class)
    public void eventListenerEvironmentPrepared() {
        System.out.println("Application Environment PreparedEvent");
    }
}
