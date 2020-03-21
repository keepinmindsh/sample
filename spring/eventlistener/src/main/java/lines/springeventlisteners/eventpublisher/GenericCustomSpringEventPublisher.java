package lines.springeventlisteners.eventpublisher;

import lines.springeventlisteners.command.Command;
import lines.springeventlisteners.event.custom.GenericCommandSprintAppEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class GenericCustomSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void doStuffAndPublishAnEvent(final Command command, boolean success){
        System.out.println("Publishing Generic Event.");
        GenericCommandSprintAppEvent genericSpringEvent = new GenericCommandSprintAppEvent(command, success);
        applicationEventPublisher.publishEvent(genericSpringEvent);
    }
}
