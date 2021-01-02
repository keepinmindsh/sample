package lines.comm.provider;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LinesProvider<ParamT> {

    private final ParamT paramT;
    private final Object checkVal;
}
