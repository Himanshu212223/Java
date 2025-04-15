# Object Relational Mapping (ORM)

Object Relational Mappling was introduced to map the Java Objects (of class) to Relation (Tables) so that the object model can be automatically translated to relation model and vice versa.

To use ORM, Java Persistence API (JPA) specification is used.

JPA is a specification that defines standard for using Object Relational Mapping to interact with Relational Database.

JPA has various implementations like Hibernate, OpenJPA, EclipseLink, etc, but primarily focus on Hibernate.


## JPA vs Hibernate vs Spring Data JPA:
|   Term	|   Description|
|-----------|----------------|
| JPA	|   Specification (what to do) |
| Hibernate|	Implementation of JPA (how to do it)|
| Spring Data   | JPA	Abstraction layer that simplifies JPA usage in Spring apps|


## Features of ORM

1. It resolves the Object-Relational Impedance mismatch by mapping
- Java Classes to Table in the Database
- Variables to Columns of the Table
- Objects to the Rows in the Table

2. No need to write the SQL Queries.

3. Independent from Database, means all the Database verdors provides support to ORM.



## Dependency to be added on pom.xml file

Copy and paste the below dependencies on pom.xml file.

```
<!-- Dependency to configure JPA with Spring Boot -->

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Dependency to configure mysql with Spring Boot -->

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
    <version>8.0.25</version>
</dependency>
```

## Add Properties to configure Data Source and SQL

In the `src/main/resources/application.properties` file, add the below configurations.

```
spring.datasource.url = jdbc:mysql://localhost:3306/dataBase_Name
spring.datasource.username = root
spring.datasource.password = root

spring.jpa.show-sql= true
spring.jpa.generate-ddl= true
spring.jpa.hibernate.ddl-auto= update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
```

- In the `spring.datasource.url`, provide the name of the Database in place of `dataBase_Name`.
- Use the mysql username and password.


## Annotations to Define Entity and Columns

### 1. Annotation to Define Entity

Entity is the Java Class which is mapped to the Table and its variable represents the columns of the Table and its Objects represents the rows of the table.

To mark a Java Class as Entity, we use below Annotation.
```
@Entity
```

- It is a Class level Annotation to mark the class as Entity.




### 2. Annotation to Define Table

> ⚠️ Optional - It is only required if your Table Name and Entity Class name is different.

It specifies the table with which the entity Class is mapping.

```
@Entity
@Table(name="table_Name")
```

- It is also a class level Annotation.
- It should be used with `@Entity` Annotattion.


### 3. Annotation to Define Primary Key

To declare a identifier or variable of the Class as *Primary Key* we uses below Annotation - 
```
@Id
``` 

- It is a field level or variable level annotation.

### 4. Annotation to Define Columns

> ⚠️ Optional - It is only needed if your Entity Class variable name is different from the Table Column name.

It specifies the column with which we want to map the Class variable.

```
@Column(name="column_name")
```

- It is also a field or variable level annotation.


### 5. Annotation to Define Attributes which are not stored on Table

This annotation is used to define the attribute which need not to be saved on the Table.

> ⚠️ Optional - It is only required when we are creating a variable on the Entity class but doesn't want to store it on Table.

```
@Transient
```

- It is also a field or variable level annotation.

### 6. Annotation to define Enumerated column

> ⚠️ Optional - Use it when you are using Enum data to be stored on the Table.

Suppose we have a column and we want to store a Enum value to it.

We use below annotation-
```
@Enumerated(EnumType.STRING)
```

For Example-
```
public enum EmployeeLevel {
    L1, L2, L3, L4, L5, L6 ;
}


@Entity
public class Employee {
    @Id
    private Integer empID ;

    @Enumerated(Enum.Type.STRING)
    private EmployeeLevel empLevel ;
}
```

## Annotation for Transaction Management

Transacation Management is used to make the database consistency with the entity and prevent the database get corrupted.

**We should always use this Annotation.**.

```
@Transactional
```
-   It is a Class Level Annotation.
-   It should be used at the **Service Layer** where we are using the custom logic to perform options on the entity.


# Approach to define Repository

There are many approaches to use the Repository to perform storage, retrieval and search of data from entity.

1. Entity Manager
2. Using CrudRepository (preferred)


## 1. Entity Manager

EntityManager is a core part of JPA (Java Persistence API) and is used to interact directly with the persistence context and the database.

### Annotation for Entity Manager

```
@PersistenceContext
```
This Annotation should be used while using the EntityManager.

```
	@PersistenceContext
	private EntityManager entityManager ;
```

-   This Annotation should be used in either Repository or on Service Layer.