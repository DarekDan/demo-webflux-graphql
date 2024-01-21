package org.example.demowebfluxgraphql.resolvers;

import org.example.demowebfluxgraphql.entities.Book;
import org.example.demowebfluxgraphql.repositories.BookRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookResolver {

    private final BookRepository bookRepository;

    public BookResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    Iterable<Book> books() {
        return bookRepository.findAll();
    }

}
