package lines.springeventlisteners.event.custom;

import lines.springeventlisteners.command.Command;

public class GenericCommandSprintAppEvent extends GenericSpringEvent<Command>
{
    public GenericCommandSprintAppEvent(Command what, boolean success) {
        super(what, success);
    }
}
