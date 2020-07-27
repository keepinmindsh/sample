package lines.command;

import lines.command.inf.Command;
import lines.model.RequestVO;
import lines.model.ResponseVO;
import lines.queue.QueueStorage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequestAddCommand implements Command<ResponseVO> {

    private final RequestVO requestVO;

    @Override
    public ResponseVO execute() {

        QueueStorage.addItem(requestVO.getItemKey(), requestVO);

        ResponseVO responseVO = new ResponseVO();

        responseVO.setItemKey(requestVO.getItemKey());

        return responseVO;
    }
}
