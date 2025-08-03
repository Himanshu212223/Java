# Records in Java

- In Java, a record is a special type of class introduced in Java 14 (preview) and made stable in Java 16.

- It is used to create immutable data classes with minimal boilerplate.

- Records are usually used as DTO (Data Transfer Object).

Suppose we have below Student Record - 
```
public record Students(int rollNo, String name) {

}
```

The Above Record Code is equivalent to below `Constant Class` -

```
public final class Student {
    private final int rollNo;
    private final String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public int rollNo() { return rollNo; }
    public String name() { return name; }

    @Override
    public boolean equals(Object o) { ... }

    @Override
    public int hashCode() { ... }

    @Override
    public String toString() {
        return "Student[rollNo=" + rollNo + ", name=" + name + "]";
    }
}
```


Now, to use it in our `main class` you can refer below code - 

```
public class App 
{
    public static void main( String[] args )
    {
        Students stud1 = new Students(12, "Test Student");
        
        //	stud1.name("Test Student2");   --> This is not allowed as 
        //	Records and its attributes are immutable.
        
        //	Below are the Getters 
        System.out.println( stud1.rollNo() );
        System.out.println( stud1.name() );
    }
}
```


## Note
- You cannot change field values after creation → immutable.

- You cannot define setters.

- You can define additional methods if needed:

```
public record Student(int rollNo, String name) {
    public String uppercaseName() {
        return name.toUpperCase();
    }
}
```