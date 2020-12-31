package lines.module.sample.handler;

import lines.module.sample.converter.BoardDtoConverter;
import lines.module.sample.model.Board;
import lines.module.sample.model.BoardDto;
import lines.module.sample.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class BoardHandler {
    private final BoardRepository boardRepository;
    private final BoardDtoConverter boardDtoConverter;

    @Autowired
    public BoardHandler(@NonNull BoardRepository boardRepository,
                        @NonNull BoardDtoConverter boardDtoConverter) {
        this.boardRepository = boardRepository;
        this.boardDtoConverter = boardDtoConverter;
    }

    public Mono<ServerResponse> getBoard(ServerRequest request) {
        long boardId = Long.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<Board> boardMono = boardRepository.findOne(boardId);
        Mono<BoardDto> boardDtoMono =boardMono.map(boardDtoConverter::convert);
        return boardDtoMono.flatMap(boardDto -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromObject(boardDto))
                .switchIfEmpty(notFound));
    }
}
