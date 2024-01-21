package org.example.demowebfluxgraphql.builders;

import org.springframework.stereotype.Component;

@Component
public class GraphQLQueryBuilder {
    private final StringBuilder queryBuilder = new StringBuilder();

    public GraphQLQueryBuilder query(String name, String body) {
        queryBuilder.append(String.format("{ %s { %s } }", name, body));
        return this;
    }

    public GraphQLQueryBuilder mutation(String name, String body) {
        queryBuilder.append(String.format("mutation { %s { %s } }", name, body));
        return this;
    }

    public String build() {
        return String.format("{\"query\":\"%s\"}", queryBuilder.toString()
                .replaceAll("\"", "\\\\\""));
    }
}

