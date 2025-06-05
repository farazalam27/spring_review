# Books API

A Spring Boot REST API for managing books and authors.

## Description

This project is a RESTful API built with Spring Boot that allows users to manage books and authors. It provides endpoints for creating, retrieving, and listing books and authors.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Maven
- Lombok

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

The application will start on port 8080 by default.

## API Endpoints

### Books

- `PUT /books/{isbn}` - Create or update a book with the specified ISBN
- `GET /books` - Get a list of all books

### Authors

- `POST /authors` - Create a new author
- `GET /authors` - Get a list of all authors
- `GET /authors/{id}` - Get an author by ID

## Data Model

### Book

- `isbn` (String) - The ISBN of the book (Primary Key)
- `title` (String) - The title of the book
- `authorEntity` (AuthorEntity) - The author of the book

### Author

- `id` (Long) - The ID of the author (Auto-generated)
- `name` (String) - The name of the author
- `age` (Integer) - The age of the author

## Database Configuration

The application is configured to connect to a PostgreSQL database with the following properties:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=changemeinprod!
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
```

The `spring.jpa.hibernate.ddl-auto=update` property ensures that the database schema is automatically updated based on the entity classes.
