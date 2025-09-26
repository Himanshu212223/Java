# String -

String is the type of object that can store a sequence of characters enclosed by double quotes and every character is stored in 16 bits, i.e., using UTF 16-bit encoding.

### Ways of Creating a Java String
---------------------------------------------
There are two ways to create a string in Java:
1. String Literal
2. Using new Keyword


### 1. String literal (Static Memory)
To make Java more memory efficient (because no new objects are created if it
exists already in the string constant pool).

Example -
```
String str = “GeeksforGeeks”;
```


### 2. Using new keyword (Heap Memory)
```
String s = new String("Welcome");
```
In such a case, JVM will create a new string object in normal (non-pool) heap memory and the literal "Welcome" will be placed in the string constant pool. The variable s will refer to the object in the heap (non-pool)



## Interfaces and Classes in Strings in Java

### CharSequence Interface

- CharSequence Interface is used for representing the sequence of Characters in Java. 
- Classes that are implementing this interface provides basic methods such as length(), charAt(), subSequence() and toString().


### 1. String 

- String is an **immutable** class in Java, which means that once a String object is created, its value cannot be changed. 
- If you want to modify a string a new String object is created and the original remains unchanged.

```
// Method 1
String str= "statement1";

// Method 2 
String str= new String("statement1");
```


### 2. StringBuffer
- StringBuffer is a peer class of String, it is **mutable** in nature and it is thread safe class. 
- We can use it when we have multi threaded environment and shared object of string buffer i.e, used by mutiple thread. 
- As it is thread safe so there is extra overhead, so it is mainly used for multithreaded program.

```
StringBuffer demoString = new StringBuffer("GeeksforGeeks");
```

> ### What is Thread Safe
> In Java, thread-safe means that a piece of code, class, or object can be safely used by multiple threads at the same time without leading to incorrect behavior, data corruption, or unexpected results.
>
> When multiple threads run concurrently, they may read and write shared data at the same time. Without precautions, this can cause issues like:
> 
> Race conditions – two threads modify the same data at the same time.
> 
> Data inconsistency – partial updates visible to other threads.
> 
> Unexpected results – program behaves differently depending on timing.




### 3. StringBuilder
- StringBuilder in Java represents an alternative to String and StringBuffer Class.
- It creates a **mutable** sequence of characters and it is not thread safe. 
- It is used only within the thread , so there is no extra overhead , so it is mainly used for single threaded program.

```
StringBuilder demoString = new StringBuilder(); 

demoString.append("statement1"); 
```

#### Difference between Spring and Spring Builder


|   Feature |	Spring (Framework)  |	StringBuilder (Class)   |
|-----------|-----------------------|---------------------------|
| Type	    | Framework/library	    | Core Java class           |
| Purpose	| Build enterprise apps (DI, MVC, etc.)	| Build and manipulate mutable strings |
| Scope	    | Huge ecosystem (Spring Boot, Data, Security, etc.)	| Limited to string handling |
| Thread-safety	| Depends on components used	| Not thread-safe (StringBuffer is) |


## How Strings are Stored in Java Memory

### String literal

Whenever a String Object is created as a literal, the object will be created in the String constant pool. This allows JVM to optimize the initialization of String literal. The string constant pool is present in the heap.

Example 1: Using String literals to assigning char sequence value.

```
String str1 = "Hello";
```

![](./Screenshots/string%20const%20pool.png)

Example 2: When we initialize the same char sequence using string literals.

```
String str1 = "Hello";
String str2 = "Hello";
```
![](./Screenshots/string%20const%20pool2.png)

### Using new Keyword
- The string can also be declared using a new operator i.e. dynamically allocated. 
- In case of String are dynamically allocated they are assigned a new memory location in the heap . 
- This string will not be added to the String constant pool.

Example 1: Using new keyword to assign a char sequence to a String object.

```
String str1 = new String("John"); String str2 = new String("Deo")
```

![](./Screenshots/string%20const%20pool3.png)

If we want to store this string in the constant pool then we will need to “intern” it.

Example 2: Using .intern() to add a string object in string constant pool.

 // this will add the string to string constant pool.
String internedString = demoString.intern(); 

> **It is preferred to use String literals as it allows JVM to optimize memory allocation.**