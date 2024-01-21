package org.example.demowebfluxgraphql;

import com.github.javafaker.Faker;
import org.example.demowebfluxgraphql.entities.Book;
import org.example.demowebfluxgraphql.repositories.BookRepository;
import org.instancio.Instancio;
import org.instancio.Model;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Collectors;

import static org.instancio.Select.field;

@SpringBootApplication
public class DemoWebfluxGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebfluxGraphqlApplication.class, args);
    }


    @Bean
    ApplicationRunner applicationRunner(BookRepository bookRepository) {
        return args -> {
            Faker faker = new Faker();
            Model<Book> bookModel = Instancio.of(Book.class)
                    .ignore(field(Book::getId))
                    .supply(field(Book::getAuthor), () -> faker.book()
                            .author())
                    .supply(field(Book::getTitle), () -> faker.book()
                            .title())
                    .toModel();
            bookRepository.saveAll(Instancio.stream(bookModel)
                    .limit(10)
                    .collect(Collectors.toList()));
        };
    }

}
