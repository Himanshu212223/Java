# Spring Data

Since we have observed that to perform the operations over Entity, we were defining the logics at the Repository level.

This is a bit time and effort consuming task if we are managing many Entities.

Spring Data provides out of the box facilities through its repositories which are interfaces associated with entity and provide methods to perform Database operations.

It automatically generates the implementation class of the interface for entity class.

We can consume this by creating Interface extending CrudRepository.

So, the Annotations which were used to defind Entity and Table will be same but the definition of Repository will be different.

## Defining Repository

We are using CrudRepository to define Repository-

```
public interface MyRepository extends CrudRepository<EntityClass, PrimaryKeyDataType> {}
```





---------------------------------
---------------------------------

# DTO Class

DTO class is also called Data Transfer Object class.

It is used to transfer the data from one class to another class.

For example - If we want to move the data from API Layer (Presentation Layer) to Service Layer, then we uses DTO Class object.

We usually use `@Data` Annotation as it automatically provides the getters and setters and we don't have to manually define it.

```
@Data
```
-   It is a class level Annotation.
-   It can be used at DTO and with Entity Class as well.

This Annotation should be imported from-

```
import lombok.Data;
```
## Dependency for Data Annotation needs to be added on pom.xml file

Copy paste the below dependency on pom.xml file.

```
<!-- Dependency for Data Annotation -->

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version> <!-- use latest stable version -->
    <scope>provided</scope>
</dependency>
```

But it is still difficult to copy the Data from DTO Class Object and set it into Entity Class object using the getters setters provided by `@Data` Annotation as `@Data` Annotation only defines the getter setter for us.

To reduce some multiple line of code just to copy the data from DTO to entity, we use `ModelMapper`.


## Dependency for Model Mapper needs to be added on pom.xml file

```
<!-- Dependency for Model Mapper Class -->
		
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>2.3.5</version>
</dependency>
```

#### How to user it ?

```
//  Firstly create an object of model mapper at class level

private ModelMapper modelMapper = new ModelMapper();


//  Then you can use it inside the class like-

CustomerDTO custDTO = modelMapper.map(customer, CustomerDTO.class);

OR

Customer customer = modelMapper.map(customerDTO, Customer.class) ;
```

Model Mapper should be imported from below package-
```
import org.modelmapper.ModelMapper;
```