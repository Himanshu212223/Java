# Understand Spring Boot Annotations

Topics - 

1. Main Class Annotations
    - @ComponentScan
    - @SpringBootApplication

2. Controller Layer Annotation
    - @Controller
    - @RequestMapping
    - @ResponseBody
    - @RestController
    - @GetMapping
    - @PostMapping
    - @PutMapping
    - @DeleteMapping
    - @RequestParam
    - @PathVariable
    - @RequestBody

3. Service Layer Annotation
    - @Service

4. Repository Layer Annotation
    - @Repository

5. Dependency Injection
    - @Autowired




# 1. Main Class Annotations

## @ComponentScan Annotation

- It is used on the main class.
- It should always be used with `@Configuration` Annotation.
- This Annotation helps to define the location where have to look for Beans.
- It automatically Scans the current package and Sub-package.
- If we wants to add Bean of someother package, we can specify the location like below - 

```
@SpringBootApplication
@ComponentScan ( basePackages = "name-of-that-package" )
public class ProjectApplication {

	public static void main(String[] args) {
        //	SpringApplication.run(ProjectApplication.class, args);
		
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ProjectApplication.class, args) ;
		System.out.println( applicationContext.getBean("employeeService") ) ;
	}

}

```

- If you wants to exclude some package as well we can use **exclusion** like below - 


```
@SpringBootApplication
@ComponentScan ( basePackages = "name-of-that-package" , excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE , classes = {ClassName.class}) )

public class ProjectApplication {

	public static void main(String[] args) {
        //	SpringApplication.run(ProjectApplication.class, args);
		
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ProjectApplication.class, args) ;
		System.out.println( applicationContext.getBean("employeeService") ) ;
	}

}

```



## @SpringBootApplication Annotation

- **@SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan**.

- **@Configuration** - Marks the class as a source of bean definitions (like an XML configuration file in traditional Spring).

- **@EnableAutoConfiguration** - Tells Spring Boot to automatically configure your application based on the dependencies on the classpath.

- **@ComponentScan** -Tells Spring to scan the current package and its sub-packages for components like @Controller, @Service, @Repository, and @Component.

So, using @SpringBootApplication helps reduce boilerplate and makes your code cleaner.


_______________________
_______________________

# 2. Controller Layer Annotation

## @Contoller

- It is a class level annotation.
- It is used to mark a class as Controller where we define the Project APIs.

When a client hits the endpoint, the request will flow like -  

Server → Dispatcher Servlet (uses Handler Mapping) → Respective Controller

- Server can be Tomcat or jetty etc.

- Dispatcher Servlet help to identify on which Controller the endpoind is defined.

```
@Controller 
public class EmployeeController {

} 
```

## @RequestMapping

- It is used on Controller Class.
- It is used to Map the path for the endpoint.
- Ex - 

```
@Controller 
public class EmployeeController {

    @RequestMapping(path = "/getEmployee", method = RequestMethod.GET)
    public String getEmployee(){
        .....
    }   
    
}
```

## @ResponseBody

- It is a method level annotation.
- It is used on Controller Class.
- It is used to mark the response as json or required form.
- Hence instead of return the response as an UI component, it will return as json object.
- Ex - 

```
@Controller 
public class EmployeeController {

    @RequestMapping(path = "/getEmployee", method = RequestMethod.GET)
    @ResponseBody
    public String getEmployee(){
        .....
    }
} 

```

## @RestController

- It is a class level annotation.
- It is the combination of `@Controller` + `@ResponseBody`
- It is used to mark a class as Controller where we define the Project APIs and it returns the response as json so we don't need to use `@ResponseBody` Annotation with all the methods of Controller.
- So instead of using `@Controller` we can directly use `@RestController`.

```
@RestController
public class EmployeeController {

    @RequestMapping(path = "/getEmployee", method = RequestMethod.GET)
    public String getEmployee(){
        .....
    }

    @RequestMapping(path = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(){
        .....
    }

    @RequestMapping(path = "/updateEmployee", method = RequestMethod.PUT)
    public String updateEmployee(){
        .....
    }

    @RequestMapping(path = "/deleteEmployee", method = RequestMethod.DELETE)
    public String deleteEmployee(){
        .....
    }
} 

```


## @GetMapping, @PostMapping, @PutMapping, @DeleteMapping

- It is method level annotation.
- It is used on Controller class.
- Instead of explicitely defining the RequestMethod on `@RequestMapping` annotation for GET Request method, we can simply use `@GetMapping` annotation.
- Hence, we can replace `@RequestMapping(path = "/getEmployee", method = RequestMethod.GET)` with `@GetMapping("/getEmployee")`.
- Similar is the case for other Request Methods as well.

Ex - 

```
@RestController
public class EmployeeController {

    @GetMapping("/getEmployee")
    public String getEmployee(){
        .....
    }

    @PostMapping("/addEmployee")
    public String addEmployee(){
        .....
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(){
        .....
    }

    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(){
        .....
    }
} 

```


## @RequestParam

- It is a method level annotation (in the arguments).
- It is used on Controller class.
- When we wants to receive some `param` value from the request, so to receive the value of the param we use this Annotation.
- The name of the argument should be same on the url Param name.

Ex - 

```
@RestController
public class EmployeeController {

    @GetMapping( "/getEmployeeById" )
    public String getEmployeeById ( @RequestParam ( name="empId" ) Integer empId ) {
        .....
    }
} 

```

So, user can use the url like - 

```
/getEmployeeById?empId=34
```


## @PathVariable

- It is a method level annotation (in the arguments).
- It is used on Controller class.
- It is used to receive the url path variable used on the url.

Ex - 

```
@RestController
public class EmployeeController {

    @GetMapping( "/getEmployeeById/{empId}" )
    public String getEmployeeById ( @PathVariable ( name="empId" ) Integer empId ) {
        .....
    }
} 

```

So, user can use the url like - 

```
/getEmployeeById/34
```


## @RequestBody

- It is a method level annotation (in the arguments).
- It is used on Controller class.
- It is used to receive the data sent on the request body.
- Hence it converts the json request body into Java object.

Ex - 

```
@RestController
public class EmployeeController {

    @GetMapping( "/getEmployeeById/{empId}" )
    public String getEmployeeById ( @RequestBody Employee empObject ) {
        .....
    }
} 

```

So, user can use the url like - 

```
/getEmployeeById/34
```

and the Request body could be - 
```
{
    "empId" : 23,
    "empName" : "Test User"
}
```


_______________________
_______________________

# 3. Service Layer Annotation

## @Service

- It is a class level annotation.
- It is used to mark a class as Service where we define the Business Logics.
- It is a specialization of `@Component`.

When we mark any class as `@Component` then that particular class is managed by Spring and hence called Spring Managed Bean.

Hence, `@Service` is also a component but given a special name as Service to differentiate among other components like controller or repository component and hence easy to understand for developers.


_______________________
_______________________


# 4. Repository Layer Annotation

## @Repository

- It is a class level annotation.
- It is used to mark a class as Repository which interacts with Database.
- It is a specialization of `@Component`.

When we mark any class as `@Component` then that particular class is managed by Spring and hence called Spring Managed Bean.

Hence, `@Repository` is also a component but given a special name as Repository to differentiate among other components like controller or Service component and hence easy to understand for developers.


_______________________
_______________________

# 5. Dependency Injection Annotation

## @Autowired

- It is a field Annotation.
- It is used to inject the dependency class on the required layer.
