# Memory Leaks in 

- In programming, a memory leak happens when a program keeps using memory but does not give it back when it's done. 
- It simply means the program slowly uses more and more memory, which can make things slow and even stop working.


## Working of Memory Management in Java
- Java has automatic garbage collection, which simply means that Java can automatically free up memory for objects that are no longer in use or no longer needed.
- But if our program creates many objects but keeps references to them even if they are not needed, the garbage collector cannot destroy those objects. If memory use grows beyond the allowed limit, the program will crash.

> ### Note: 
>
>If an object is no longer needed, it is important to remove references to it so the garbage collector can free its memory.


# Why Do Memory Leaks Happen in Java?
- We know that Java cleans up memory automatically with the help of garbage collector but still memory leaks can happen, this happens because our program keep holding onto things that are no longer needed. - Our Java program still remembers these objects and thinks they are important and that's why it does not remove them and this wastes memory cause the problems.

Example - 
```
// Demonstrating memory leaks in Java 

import java.util.ArrayList;
import java.util.List;

public class Geeks {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        
        while (true) {
            Object obj = new Object();
            // The list keeps growing and holds references to all objects
            list.add(obj);  
        }
    }
}
```

Explanation: In the above example, the program keep on creating new object and each object is added to the list because list stores the references of all the objects and because of this memory usage keeps on growing and causes OutOfMemoryError.

## Tools to Find Memory Leaks
There are multiple tools that help us to detect memory leaks by showing which object is using the most memory, and the list of such tools are listed below:

- VisualVM (comes with JDK)
- Eclipse Memory Analyzer (MAT)
- Java Mission Control
- YourKit Java Profiler

## What Happens If Memory Keeps Leaking?

If our program keep on leaking memory it means the program will use up all the memory as much as it can use. After some time, the program will stop working and will show an error like this:
```
java.lang.OutOfMemoryError: Java heap space
```
This means Java ran out of memory to create new things it needs.


## How to Avoid Memory Leaks?
We can avoid memory leaks by keeping few things in our mind which is listed below:

- Stop keeing things that we do not need in our program do not initialize unnecessary variables and list items to null.
- Do not let lists or caches keep growing forever without removing old stuff.
- It is always recommended to close files and database connections when we are done with them.
