package lines.socket.server.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Messages {
    private String eventId;
    private String eventDt;
}
