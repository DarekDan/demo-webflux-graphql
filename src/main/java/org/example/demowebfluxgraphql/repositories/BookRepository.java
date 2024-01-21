package org.example.demowebfluxgraphql.repositories;

import org.example.demowebfluxgraphql.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
