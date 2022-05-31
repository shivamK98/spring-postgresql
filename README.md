# spring-postgresql

A REST API service built using Spring Boot and PostgreSQL.<br/>
All CRUD operations implemented which can be accessed using HTTP methods like GET, POST, PUT, DELETE.

## Tools and Technologies used

* Spring boot 2.7.0
* PostgreSQL
* Hibernate
* JPA
* Gradle 7.4.2
* IntelliJ Idea
* Java 8

## Step to install

1. **Clone the application**

```bash
git clone https://github.com/shivamK98/spring-postgresql.git
```

2. **Build and run the backend app**

```bash
mvn package
```

using java-jar command :

```bash
java -jar target/spring-postgresql-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using Maven Plugin :

```bash
mvn spring-boot:run
```

The backend server will start at <http://localhost:8080>.

> Note: I am currently using local PostgreSQL server.