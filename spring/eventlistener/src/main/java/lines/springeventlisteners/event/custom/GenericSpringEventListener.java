package lines.springeventlisteners.event.custom;

import lines.springeventlisteners.command.Command;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class GenericSpringEventListener  {

    @EventListener
    public void handleSuccessful(GenericCommandSprintAppEvent event) {
        Command command = event.getWhat();

        command.execute();
    }
}
