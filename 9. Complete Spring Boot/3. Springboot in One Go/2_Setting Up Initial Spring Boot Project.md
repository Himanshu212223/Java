# How to create the First Spring Boot Application..?

## Setup Simple Spring Boot Project

We can use the [spring boot initializr](https://start.spring.io/) page on the browser to create the spring boot application.

Here's what the configuration could look like.

![Spring Boot Initializr](../screenshots/springbootinitializr.png)

Click on **Generate** button and it will get downloaded on your pc, extract the file and import it as existing maven project on your IDE like Eclipse.

### What is Jar and War

#### Jar - Java Archieve
We use Jar when we wants to design stand along application (a single application which receive the request and return response).

#### War - Web Archieve
We use War when we are designing a web application which contains HTML, CSS and JS files were UI will consume the backend. 


## Understand Layered architecture

![Spring Boot Initializr](../screenshots/layers%20in%20springboot.png)

**Controller Layer** - It is the entry point of the Spring Boot Application in which we define API enpoints. It receive the request process it (using Service Layer) and provide response.

**Service Layer** - Service Layer is the place where we define the Business logics. So it process the request of Controller Layer, do the needfull and return the data to Controller Layer.

**Repository Layer** - Repository Layer usually interacts with the Database. If Service Layer needs or perform any activity with Database it interacts with Repository Layer.

**DTO** - It is Data Transfer Object which is used to transport Data from one Layer to other to stablish communication between layers.

**Utility** - Utilities are the helping functions which are getting consumed across all the Layers.

**Entity** - An Entity class in Spring Boot is a Java class that maps to a database table. It represents a persistent object, and each instance corresponds to a row in that table.

**Config** - It is used to define the configurations which we are going to use in our application let it be defining the url to communication with Database or defining the place where we can store logs.

So in our SpringBoot Application we can define different packages for different Layers.


```
project
|-- src/main/java
    |-- packageName
    |   |-- ProjectApplication.java
    |
    |-- packageName.controller
    |   |-- APIClass.java
    |
    |-- packageName.service
    |   |-- serviceClass.java
    |
    |-- packageName.repository
    |   |-- entityRepositoryInterface.java
    |
    |-- packageName.entity
    |   |-- entityClass.java
    |
    |-- packageName.dto
    |   |-- entityClassDTO.java

```