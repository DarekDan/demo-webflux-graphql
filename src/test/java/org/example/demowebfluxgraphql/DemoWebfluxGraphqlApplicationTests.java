package org.example.demowebfluxgraphql;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.demowebfluxgraphql.builders.GraphQLQueryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class DemoWebfluxGraphqlApplicationTests {

    @LocalServerPort
    private int port;

    WebTestClient webTestClient;

    @Autowired
    ApplicationContext context;

    @Autowired
    GraphQLQueryBuilder builder;

    @BeforeEach
    void setUp(){
        webTestClient = WebTestClient.bindToApplicationContext(context)
                .configureClient().baseUrl("http://localhost:" + port)
                .build();
    }

    @Test
    void contextLoads() {
        // Test to ensure the application context loads successfully
    }

    @SneakyThrows
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
