# WebFlux GraphQL Demo Project

## Overview
This project demonstrates the integration of GraphQL with Spring WebFlux, showcasing non-blocking, reactive APIs. The application provides a simple example of handling GraphQL queries and mutations in a reactive Spring Boot environment.

## Features
- **Reactive Data Handling**: Utilize Spring WebFlux for efficient, non-blocking data operations.
- **GraphQL Integration**: Explore the flexibility of GraphQL for querying and manipulating data.
- **Exception Handling**: Learn about handling errors gracefully in a reactive GraphQL environment.
- **Unit and Integration Tests**: Ensure code quality and functionality with comprehensive tests.

## Prerequisites
- Java 21 or later
- Maven 3.6 or later
- Any IDE supporting Spring Boot (e.g., IntelliJ IDEA, Eclipse)

## Getting Started
1. **Clone the Repository**:
   ```
   git clone https://github.com/yourusername/webflux-graphql-demo.git
   ```

2. **Navigate to the Project Directory**:
   ```
   cd webflux-graphql-demo
   ```

3. **Build the Project**:
   ```
   mvn clean install
   ```

4. **Run the Application**:
   ```
   mvn spring-boot:run
   ```

## Usage
Access the GraphQL playground at `http://localhost:8080/playground` to execute queries and mutations.

### Sample Query
```graphql
query {
  findAllBooks {
    id
    title
    author
  }
}
```

### Sample Mutation
```graphql
mutation {
  addBook(title: "New Book", author: "Author Name") {
    id
    title
    author
  }
}
```

## Testing
Run unit and integration tests with:
```
mvn test
```

## Contributing
Contributions are welcome! Please read our [Contributing Guide](CONTRIBUTING.md) for more information.

## License
This project is licensed under the [MIT License](LICENSE).

---

Feel free to modify this template to include specific details about your project, such as a more detailed description, specific configuration steps, or additional features.
