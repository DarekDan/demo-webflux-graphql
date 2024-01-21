package org.example.demowebfluxgraphql.resolvers;

import org.example.demowebfluxgraphql.entities.Book;
import org.example.demowebfluxgraphql.repositories.BookRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Controller
public class BookResolver {

    private final BookRepository bookRepository;

    public BookResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    public Flux<Book> books() {
        return Flux.fromIterable(bookRepository.findAll())
                .subscribeOn(Schedulers.boundedElastic());
    }

}
