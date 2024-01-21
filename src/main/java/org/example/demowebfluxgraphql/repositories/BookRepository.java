package org.example.demowebfluxgraphql.repositories;

import org.example.demowebfluxgraphql.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
