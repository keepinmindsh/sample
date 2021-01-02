package lines.module.sample.converter;

import lines.module.sample.model.Board;
import lines.module.sample.model.BoardDto;
import org.springframework.stereotype.Component;

@Component
public class BoardDtoConverter {
    public BoardDto convert(Board board){
        return new BoardDto();
    }
}
