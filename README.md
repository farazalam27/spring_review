# Database Project

A Spring Boot application for managing books and authors using JDBC with PostgreSQL.

## Description

This project is a simple database application built with Spring Boot that demonstrates how to use JDBC to interact with a PostgreSQL database. It provides functionality for managing books and authors, including creating, retrieving, updating, and deleting records.

## Technologies Used

- Java
- Spring Boot
- JDBC (Java Database Connectivity)
- PostgreSQL
- Docker and Docker Compose
- Lombok
- JUnit for testing

## Setup Instructions

### Prerequisites

- Java 17 or higher
- Docker and Docker Compose
- Maven

### Database Setup

The application uses PostgreSQL as its database. You can start the database using Docker Compose:

```bash
docker-compose up -d
```

This will start a PostgreSQL container with the following configuration:
- Port: 5432
- Username: postgres
- Password: changemeinprod!

### Running the Application

You can run the application using Maven:

```bash
./mvnw spring-boot:run
```

The application will start and automatically create the necessary database schema using the `schema.sql` file.

## Database Schema

The application uses two tables:

### Authors Table

```sql
CREATE TABLE "authors" (
    "id" BIGSERIAL NOT NULL,
    "name" text,
    "age" text,
    CONSTRAINT "authors_pkey" PRIMARY KEY ("id")
);
```

### Books Table

```sql
CREATE TABLE "books" (
    "isbn" text NOT NULL,
    "title" text,
    "author_id" bigint,
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn"),
    CONSTRAINT "fk_author" FOREIGN KEY (author_id)
    REFERENCES authors(id)
);
```

## Data Access Objects (DAOs)

The application uses Data Access Objects (DAOs) to interact with the database:

### AuthorDao

- `create(Author author)`: Creates a new author
- `findOne(long id)`: Finds an author by ID
- `find()`: Returns all authors
- `update(long id, Author author)`: Updates an author
- `delete(long id)`: Deletes an author

### BookDao

- `create(Book book)`: Creates a new book
- `findOne(String isbn)`: Finds a book by ISBN
- `find()`: Returns all books
- `update(String isbn, Book book)`: Updates a book
- `delete(String isbn)`: Deletes a book

## Domain Model

### Author

- `id` (Long): The ID of the author (Primary Key)
- `name` (String): The name of the author
- `age` (Integer): The age of the author

### Book

- `isbn` (String): The ISBN of the book (Primary Key)
- `title` (String): The title of the book
- `author_id` (Long): The ID of the author (Foreign Key)

## Configuration

The application is configured to connect to a PostgreSQL database with the following properties:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=changemeinprod!
spring.datasource.driver-class-name=org.postgresql.Driver
spring.sql.init.mode=always
```

The `spring.sql.init.mode=always` property ensures that the `schema.sql` file is executed on startup to create the necessary database schema.

## Testing

The application includes tests for the DAO implementations. You can run the tests using Maven:

```bash
./mvnw test
```
