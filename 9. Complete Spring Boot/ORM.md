## ORM

- It stands for Object Relational Mapping.
- It is a technique used to map Java Class Objects to Database Tables.
- Consider a Java Class User and a Database table users, ORM Frameworks like Hibernate can map the fields in the User class to Columns in the Users Table making it easy to perform CRUD operations.

## JPA Java Persistence API

- It is a way (set of rules) to achieve ORM includes interfaces and Annotations that you use in your Java classes and requires a persistence provider **(ORM tools)** for implementation.
- To use JPA, you need a persistence provider (Hibernate, OpenJPA, etc).
- These Providers implement the JPA interfaces and provide the underlying functionality to interact with databases.
- It is primarily designed for working with Relational Databases (Data stored in Tables with schema).


## Spring Data JPA

- It is built on top of the JPA specifications but not a JPA implementation itself.
- It is also designed for Relational Databases.


## Spring Data MongoDB

- It is specifically designed for Non-Relational Database like MongoDB.

pom.xml dependency - 

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <atifactId>spring-boot-starter-data-mongodb</atifactId>
</dependency>
```

Ways to Implement Spring Data MongoDB - 
1. Query Method DSL
2. Criteria API