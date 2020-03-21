package lines.springeventlisteners.beans;

import org.springframework.stereotype.Component;

@Component
public class EventHolderBean {

    private Boolean eventFired = false;

    public Boolean getEventFired() {
        return eventFired;
    }

    public void setEventFired(Boolean eventFired) {
        this.eventFired = eventFired;
    }
}
