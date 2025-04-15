# Service Layer

Layers are the way to organizing the code and Service Layer is usually used to write the business logs.

By this way, we separates the Business Logics from other part of application like Data access and API logics.

Since we know that, to Soft Couple the Classes  we uses `@Component` Annoration so that it can gets added on IoC Container and when required to inject it (or use), we uses `@Autowired` Annotation.

Spring Boot provides various Annotations like `@Service , @Repository , @Controller , @Component` based on its layers so that it would be easy for the developer to identify on which layer he is currently working.

All these annotation marks the class as Component so that it can gets added on Spring IoC Container.

So, to Define the Class of Service Layer, we uses - 

```
@Service
```

-   It is a class Level Annotation.
-   It is used to mark the class as Component so that it gets added on IoC Container and can easily interacts with Presentation Layer (API Layer) and other layers. 

This Annotation should be imported from-
```
import org.springframework.stereotype.Service;
```