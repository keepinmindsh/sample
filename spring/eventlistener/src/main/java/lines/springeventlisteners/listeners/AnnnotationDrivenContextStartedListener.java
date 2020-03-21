package lines.springeventlisteners.listeners;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnnotationDrivenContextStartedListener {
    // @Async
    @EventListener
    public void handleContextStart(ContextStartedEvent cse){
        System.out.println("Handling Context started event");
    }

}
