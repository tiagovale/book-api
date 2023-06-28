## Introduction

This is simple rest api regarding the management of the books.

## Technologies

- Spring Boot
- Spring Data JPA
- Spring Ioc
- Java 17
- Maven
- Junit 5 with Mockito

## Features

- POST("localhost:8080/books")
- PUT("localhost:8080/books/1")
- GET("localhost:8080/books")
- DELETE("localhost:8080/books/1")

## Getting Started

1. Clone the repository.
2. Open the project in your preferred IDE.
3. Build the project using Maven: `mvn clean install`.
4. Run the application: `mvn spring-boot:run`.

In case you want to run Docker
1. Follow the previous steps until the third step
2. On the terminal console go to the root of the project
3. run this command: docker run -p 9090:8080 book-api-docker.jar
4. The port to the requests it will be the 9090


## Usage
To use this api you need to run the application.
The URL ("localhost:8080/books) it will be available to receive requests
For that you can use tools such as Postman to test it.
