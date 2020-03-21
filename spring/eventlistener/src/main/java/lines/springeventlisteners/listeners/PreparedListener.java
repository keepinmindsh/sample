package lines.springeventlisteners.listeners;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class PreparedListener {

    @EventListener(ApplicationPreparedEvent.class)
    public void onApplicationEvent() {
        System.out.println("Application Prepared Event");
    }
}
