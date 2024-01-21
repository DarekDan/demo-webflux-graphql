package org.example.demowebfluxgraphql;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoWebfluxGraphqlApplicationTests {

    @LocalServerPort
    private int port;

    WebTestClient webTestClient;

    @Autowired
    ApplicationContext context;

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

    @Test
    void testGraphQLQueryFindAllBooks() {
        String query = "{ books { id title author } }";

        webTestClient.post().uri("/graphql")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"query\":\"" + query + "\"}")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.data.books").isArray()
                .jsonPath("$.data.books[*].id").exists()
                .jsonPath("$.data.books[*].title").exists()
                .jsonPath("$.data.books[*].author").exists();
    }
}
