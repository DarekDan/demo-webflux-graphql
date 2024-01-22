package org.example.demowebfluxgraphql;

import lombok.extern.slf4j.Slf4j;
import org.example.demowebfluxgraphql.builders.GraphQLQueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Slf4j
class DemoWebfluxGraphqlApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    GraphQLQueryBuilder builder;

    @Test
    void contextLoads() {
        // Test to ensure the application context loads successfully
    }

    @Test
    void testGraphQLQueryFindAllBooks() {
        builder.query("books",  "id title author");

        webTestClient.post().uri("/graphql")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(builder.build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.data.books").isArray()
                .jsonPath("$.data.books[*].id").exists()
                .jsonPath("$.data.books[*].title").exists()
                .jsonPath("$.data.books[*].author").exists();
    }
}
