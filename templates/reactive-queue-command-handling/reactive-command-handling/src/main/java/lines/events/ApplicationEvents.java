package lines.events;

import lines.command.DoSomethingCommand;
import lines.command.inf.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Configuration
@Slf4j
public class ApplicationEvents {

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    @EventListener(ApplicationReadyEvent.class)
    public void EventListenerExecute(){

        scheduledExecutorService.scheduleAtFixedRate(() -> {

            log.info("EventListener Command");

            Command command = new DoSomethingCommand();

            command.execute();
        }, 5 , 10 , TimeUnit.SECONDS);
    }
}
