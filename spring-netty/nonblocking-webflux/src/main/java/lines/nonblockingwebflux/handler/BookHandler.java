package lines.nonblockingwebflux.handler;

import lines.nonblockingwebflux.model.Book;
import lines.nonblockingwebflux.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Slf4j
public class BookHandler {

//    private final BookService bookService;
//    public BookHandler(BookService bookService) {
//        this.bookService = bookService;
//    }
//    public Mono<ServerResponse> findById(ServerRequest request) {
//        String id = request.pathVariable("id");
//        return ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(bookService.findById(id), Book.class);
//    }
//    public Mono<ServerResponse> findAll(ServerRequest request) {
//        return ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(bookService.findAll(), Book.class);
//    }
//    public Mono<ServerResponse> save(ServerRequest request) {
//        final Mono<Book> book = request.bodyToMono(Book.class);
//        return ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(fromPublisher(book.flatMap(bookService::save), Book.class));
//    }
//    public Mono<ServerResponse> delete(ServerRequest request) {
//        String id = request.pathVariable("id");
//        return ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(bookService.deleteById(id), Void.class);
//    }
}
