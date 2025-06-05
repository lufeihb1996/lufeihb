# lufeihb Spring Boot Application

This repository contains a minimal Spring Boot setup.

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
