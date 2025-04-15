# Spring Boot and its Layers

Create and download a sample Spring Boot Project from [Spring Initializr](https://start.spring.io/).

Extract the downloaded file and import it as Existing Maven Project on IDE like Eclipse.

The Spring Boot expect you to keep you project structure like below-
```
project
|-- src/main/java
    |-- packageName
    |   |-- ProjectApplication.java
    |
    |-- packageName.entity
    |   |-- entityClass.java
    |
    |-- packageName.repository
    |   |-- entityRepositoryInterface.java
    |
    |-- packageName.service
    |   |-- serviceClass.java
    |
    |-- packageName.api
    |   |-- APIClass.java
```

## Layers of Spring Boot

1. **Persistence Layer** - This layer interacts with Databases like mySQL, MongoDB, etc. The persistence layer is the part of your Spring Boot application that deals with storing, retrieving, updating, and deleting data — usually from a database.

2. **Service Layer** - This layer is used to keep or write the business logics.

3. **Presentation Layer** - This layer is used to define the API endpoints which interacts with the UI.


## Annotations of Spring Boot

In **Spring**, different annotations were used like - 

`@Configuration` Annotation was used to mark the class as source from where the Application Context gets the Bean Definitions.

`@ComponentScan` Annotation was used to scan all the beans which are Annoted with @Component or @Service or @Repository or @Controller

`@EnableAutoConfiguration` Annotation was used to automatically configures the application based on dependencies that you have added.

But, **Spring Boot** provide a Annotation which is the combination of all the 3 above mentioned Annotations.

```
@SpringBootApplication 
```

-   This Annotation should be used in the **Main class which is defined at Root level where SpringApplication Run method has been called**.

-   This Annotation is **Class Level** Annotation.

-   This Annotation perform the Equivalent work of `@Configuration`, `@ComponentScan` and `@EnableAutoConfiguration`.

-   Spring Boot project which is downloaded from Spring Initializr already contains this annnotation.


## Dependencies of Spring Boot configured on pom.xml file.

Below dependencies are needed and are alredy configured when we download project from Spring initializr.

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```