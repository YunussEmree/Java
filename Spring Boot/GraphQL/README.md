# GraphQL Spring Boot Demo

A demonstration project showcasing GraphQL implementation with Spring Boot, featuring a book management system with CRUD operations.

## 🚀 Features

- **GraphQL API**: RESTful alternative with flexible querying
- **Book Management**: Create, read, update, and delete books
- **PostgreSQL Integration**: Persistent data storage
- **Spring Boot 4.0**: Latest Spring Boot features
- **JPA/Hibernate**: Object-relational mapping

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- PostgreSQL database
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## 🛠️ Setup Instructions

### 1. Database Setup

Create a PostgreSQL database:
```sql
CREATE DATABASE graphql_demo;
```

### 2. Configuration

Update `src/main/resources/application.properties` with your database credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/graphql_demo
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Build and Run

```bash
# Navigate to project directory
cd Spring Boot/GraphQL

# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## 📚 API Documentation

### GraphQL Endpoint
- **URL**: `http://localhost:8080/graphql`
- **Method**: POST
- **Content-Type**: `application/json`

### Schema

```graphql
type Book {
    id: ID!
    title: String!
    author: String!
}

type Query {
    books: [Book!]!
    bookById(id: ID!): Book
}

type Mutation {
    createBook(title: String!, author: String!): Book!
    updateBook(id: ID!, title: String, author: String): Book
    deleteBook(id: ID!): Boolean!
}
```

## 🔧 API Examples

### Query All Books
```graphql
query {
  books {
    id
    title
    author
  }
}
```

### Query Book by ID
```graphql
query {
  bookById(id: "1") {
    id
    title
    author
  }
}
```

### Create a Book
```graphql
mutation {
  createBook(title: "The Great Gatsby", author: "F. Scott Fitzgerald") {
    id
    title
    author
  }
}
```

### Update a Book
```graphql
mutation {
  updateBook(id: "1", title: "Updated Title", author: "Updated Author") {
    id
    title
    author
  }
}
```

### Delete a Book
```graphql
mutation {
  deleteBook(id: "1")
}
```

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/com/yunussemree/GraphQLDemo/
│   │   ├── Book.java                 # Entity class
│   │   ├── BookController.java       # GraphQL controller
│   │   ├── BookRepository.java       # Data access layer
│   │   └── GraphQlDemoApplication.java # Main application class
│   └── resources/
│       ├── application.properties     # Configuration
│       ├── example-request.http      # Example HTTP requests
│       └── graphql/
│           └── schema.graphqls       # GraphQL schema definition
```

## 🔍 Key Components

### Book Entity
- JPA entity with `@Entity` annotation
- Fields: `id`, `title`, `author`
- Auto-generated ID with `@GeneratedValue`

### BookController
- `@Controller` annotation for GraphQL handling
- `@QueryMapping` for query operations
- `@MutationMapping` for mutation operations
- Uses `@Argument` for parameter binding

### GraphQL Schema
- Defines `Book` type with required fields
- `Query` type for read operations
- `Mutation` type for write operations

## 🧪 Testing

### Using HTTP Client
You can use the provided `example-request.http` file with tools like:
- IntelliJ IDEA HTTP Client
- VS Code REST Client
- Postman

### Using GraphQL Playground
Access the GraphQL playground at: `http://localhost:8080/graphql`

## 📦 Dependencies

- **Spring Boot Starter GraphQL**: GraphQL support
- **Spring Boot Starter Web**: Web application support
- **Spring Boot Starter Data JPA**: Database integration
- **PostgreSQL**: Database driver
- **Spring GraphQL Test**: Testing utilities

## 🚀 Running with Docker

If you prefer using Docker for PostgreSQL:

```bash
# Run PostgreSQL container
docker run --name postgres-graphql -e POSTGRES_PASSWORD=12345 -e POSTGRES_DB=graphql_demo -p 5432:5432 -d postgres

# Start the application
./mvnw spring-boot:run
```

## 📝 Notes

- The application uses Spring Boot 4.0 SNAPSHOT
- Hibernate DDL auto is set to `update`
- SQL queries are logged for debugging
- The GraphQL endpoint is available at `/graphql`

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## 📄 License

This project is for educational purposes and demonstration of GraphQL with Spring Boot.

---

**Happy Coding! 🎉**
