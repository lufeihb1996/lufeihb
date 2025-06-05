# lufeihb Spring Boot Application

This repository contains a minimal Spring Boot setup.

## Blog Management System

The project now includes a simple blog backend built with Spring Boot,
MyBatis-Plus and a Vue frontend under `demo/mydemo`. CRUD endpoints are
available under `/posts` and data is stored in a MySQL database. Update
`src/main/resources/application.properties` with your MySQL credentials
before running the application.

To start the frontend, run the following commands inside `demo/mydemo`:

```bash
npm install
npm run dev
```

## Prerequisites

- Java 17 or later
- Maven 3.8+

## Building the project

Run the following command to build and test the project:

```bash
mvn clean package
```

## Running the application

Use the Spring Boot Maven plugin to start the application:

```bash
mvn spring-boot:run
```

The application exposes a single endpoint at `http://localhost:8080/` which returns `Hello, Spring Boot!`.
