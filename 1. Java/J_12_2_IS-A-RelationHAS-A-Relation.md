# Difference between IS-A Relationship and HAS-A Relationship

## IS-A Relationship (Inheritance)

- It represents an Inheritance Relationship.
- Implemented in Java using extends (for classes) or implements (for interfaces).

```
// Parent class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Child class
class Dog extends Animal {  // Dog IS-A Animal
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class Test {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();  // inherited from Animal
        d.bark();
    }
}

```

> ### Explanation -
>- Dog inherits from Animal.
>
>- Dog IS-A Animal, so it can use all the properties/methods of Animal.



## HAS-A Relationship (Composition / Aggregation - through Object creation)

- It represents `owning` the Relationship by having the class A as member of class B.
- Implemented in Java by declaring a class variable of another class inside a class.

```
// Class representing an Engine
class Engine {
    void start() {
        System.out.println("Engine is starting");
    }
}

// Car HAS-A Engine
class Car {
    private Engine engine;  // HAS-A relationship

    Car() {
        engine = new Engine();
    }

    void startCar() {
        engine.start(); // using Engine object
        System.out.println("Car is starting");
    }
}

public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();
    }
}

```

> ### Explanation -
>- Car has an Engine object inside it.
>
>- Car HAS-A Engine.
>
>- Car uses Engine but does not inherit from it.


| Relationship | Keyword/Concept         | Example in Java                | Meaning                      |
| ------------ | ----------------------- | ------------------------------ | ---------------------------- |
| **IS-A**     | Inheritance             | `Dog extends Animal`           | Dog **is a type of** Animal  |
| **HAS-A**    | Composition/Aggregation | `class Car { Engine engine; }` | Car **has** an Engine object |



> ### Tip:
> 
>- Use IS-A when a class is a subtype of another.
>
>- Use HAS-A when a class contains or uses another class.