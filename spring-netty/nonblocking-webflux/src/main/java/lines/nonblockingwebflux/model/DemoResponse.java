package lines.nonblockingwebflux.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DemoResponse {
    private DemoModel content;
    private boolean result;
}
