package lines.springeventlisteners.listeners;

import org.springframework.boot.ExitCodeEvent;
import org.springframework.context.event.EventListener;

public class ExitEventListener {
    @EventListener
    public void exitEvent(ExitCodeEvent event) {
        System.out.println("Exit code: " + event.getExitCode());
    }
}
