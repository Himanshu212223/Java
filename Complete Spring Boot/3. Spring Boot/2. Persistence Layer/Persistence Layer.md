# Persistence Layer

## Dependency to be added on pom.xml file

Copy and paste the below dependencies on `pom.xml` file.

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


## Add Properties to configure Data Source

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

-   In the `spring.datasource.url`, provide the name of the Database in place of `dataBase_Name`.
-   Use the mysql username and password.


## Annotations to create Entity

Since Spring Boot follow ORM (Object Relation Model), it consider the Relation (Table) as Java Object.

So, create a Class with name same as the Relation (Table) name you need and create the Class attributes with the same name as the column name.

### How to mention Class as Entity
-----------------------------------------------------------------------

To declare a Class as an entity, use the below annotation.

```
@Entity
```

-   Always remember that It is a Class level Annotation.
-   It should be imported from below library-

```
import jakarta.persistence.Entity;
````


### How to mention a Column as Primary Key
-----------------------------------------------------------------------

To make a column as Primary Key, use the below Annotation.

```
@Id
```
-   It is an attribute level annotation to mark the column as *Primary Key*.
-   It should be imported from below library-

```
import jakarta.persistence.Id;
```


-------------------------------------------------------------------------

### How to Install MySQL
We can download the mysql server locally using link - https://dev.mysql.com/downloads/installer/

Now, find the MySQL server downloaded file from `C:\Program Files\MySQL\MySQL Server 8.0\bin` etc, copy the file location and store it on System Environment Variables path.

Now, to run the mysql server, open cmd and use the below command-
```
mysql -u root -p
```

If you want to run the mysql server on different port, open cmd and use below command-
```
mysql -u root -p --port=8624
```