package lines.command.inf;

import lines.model.ResponseVO;

public interface Command<ResultR> {
    public ResultR execute();
}
