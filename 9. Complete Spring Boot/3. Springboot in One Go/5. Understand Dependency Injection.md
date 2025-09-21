# Understand Dependency Injection

Topics - 

1. Why Dependency Injection
2. Dependency Injection and Its Types
    - Filed Injection
    - Setter Injection
    -  Constructor Injection
3. Problems faced during Dependency Injection
    - Circular Dependency
    - Unsatisfied Dependency


## 1. Why Dependency Injection

Support we have a class called Order like below - 

```
public class Order {
    ...
}
```

And there is another class called User which depends upon Order class like - 

```
public class User {

    Order order = new Order () ;

    public User () {
        ... User constructor ...
    }

}
```


Hence we can see there is a `Tight Coupling` between Order and user.

Now suppose in future, developer decided to change the Order from Class to Interface and define some functionality to it.

Then it will create error on all the classes which are using the Tight Coupling of Order as we cannot create Object of Interface.

So to solve this problem we can create another class called OrderDetail which implements the Order Interface and we can create the object of OrderDetails Class on user.

But it is a long process so we can use other way like - 

```
public class User {

    Order order ;

    public User ( Order order ) {
        this.order = order ; 
        ... User constructor ...
    }

}
```
This can also be achieved by Dependency Injection as well like - 

Create a class called orderDetails which Implements the Order Interface and Annotate it with @Component then Inject it on User like below -


```
@Component
public class User {

    @Autowired
    Order order ;

    public User ( Order order ) {
        this.order = order ; 
        ... User constructor ...
    }

}
```



## 2. Dependency Injection and Its Types

### Field Injection

- Dependency is set into fileds of class.
- Spring uses reflection, it iterates over fields and resolve dependencies.


```
@Component
public class User {

    @Autowired
    Order order ;       // Here

    public User () { 
        ... User constructor ...
    }

}
```

Advantages-
- Simple and Easy to Use

Disadvantages-
- Cannot be used with immutable fields (ie., canot declare Order as final while injecting.)
- Changes of Null Pointer Exception

```
@Component
public class User {

    @Autowired
    public final Order order ;       // Here --> Immutable field

    public User () { 
        ... User constructor ...
    }

}
```



### Setter Injection

When we are using a setter method to create the object of dependency class.

Ex - 

```
@Component
public class Order {
    
    public Order () {
        System.out.println("Initializing Order);
    }

}
```


```
@Component
public class User {

    Order order ;

    @Autowired          //  Here is Setter Injection
    public void setOrder ( Order order ) {
        this.order = order ;
    }

}
```

Advantages-
- Dependency can be changed any time after object creation.
- Easy for jUnit Testing, we can pass mock objects in dependency easily.


```
public class main (String args [] ) {

    Order order = new Order () ;
    User user = new User () ;

    user.setOrder(order) ;      //  Setting the dependency after object creation.
}
```


Disadvantages-
- Fields cannot be marked as final.
- Difficult to read and maintain as per standards.



### Constructor Injection (Recommended)

- Dependency will be resolved at the time of initialization of object.
- It is recommended.

Ex - 

```
@Component
public class Order {
    
    public Order () {
        System.out.println("Initializing Order);
    }

}
```


```
@Component
public class User {

    Order order ;

    @Autowired          //  Here is the Construction Injection
    public User ( Order order ) {
        this.order = order ;
    }

}
```

So while creating the Beans, it will automatically inject the Order Bean in the User Bean.


Advantages-
- All mandatory dependencies will be injected at the time of initialization itself.
- Make 100% sure that our object will be initialized with all the required dependencies.
- Avoid Null pointer exception.
- We can **create immutable objects** using constructor injection.
- Fail at compilation  only in case of missing dependencies.


## 3. Problems faced during Dependency Injection

### Circular Dependency

When we Inject Class2 in Class 1 and at the same time Injects Class1 in Class2 it is called Circular Dependency.

Hence it will throw Error of Type Cyclic Dependency.

Ex - 

```
@Component
public class Order {

   User user ; 

    @Autowired      //  Injecting User in Order
    public Order (User user) {
        this.user = user ;
    }

}
```


```
@Component
public class User {

    Order order ;

    @Autowired          //  Injecting Order in User
    @Lazy
    public User ( Order order ) {
        this.order = order ;
    }

}
```


**To Fix this we can use `@Lazy` Annotation.**

Ex - 

```
@Component
public class Order {

   User user ; 

    @Autowired      //  Injecting User in Order
    @Lazy
    public Order (User user) {
        this.user = user ;
    }

}
```


```
@Component
public class User {

    Order order ;

    @Autowired           //  Injecting Order in User
    public User ( Order order ) {
        this.order = order ;
    }

}
```


Another way to fix it using `@PostCostruct` Annotation and method.


Ex - 

```
@Component
public class Order {

   User user ; 

    public void setUser(User user){
        this.user = user ;
    }

}
```


```
@Component
public class User {

    Order order ;

    public User ( Order order ) {
        this.order = order ;
    }

    @PostConstruct
    public void init () {
        order.setUser(this) ;
    }

}
```


### Unsatisfied Dependency

When we wants to Inject something which is not marked as Component or find more than one dependency with same name.

To fix this, we can mark the important one as `@Primary` along with `@Component`.

Also we can use `@Qualifier` annotation on Constructor Injection to fix it.