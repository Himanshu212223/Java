/*

Iterator in Java - 
________________________________________________________________

- Iterator is an interface in Java.

- It is used to iterate (loop) through elements of a Collection 
    (like ArrayList, HashSet, etc.).

- Unlike a for loop, it provides methods like:

hasNext() → returns true if there are more elements.

next() → returns the next element.

remove() → removes the last element returned by next().


Comparator in Java - 
________________________________________________________________

- Comparator is an interface in Java.

- It is used to define a custom sorting order for objects.

- You implement compare(T o1, T o2) method:

returns negative if o1 < o2

returns 0 if o1 == o2

returns positive if o1 > o2

We can create a custom class which will implement Comparator class 
and define the custom methods.


*/

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.age, s2.age); // sort by age ascending
    }
}

public class J_23_0_IteratorAndComparator {

    public static void iteratorCodeExample() {

        List<Integer> linkedList = new LinkedList<>();

        linkedList.add(45);
        linkedList.add(15);
        linkedList.add(21);
        linkedList.add(20);

        Iterator<Integer> itr = linkedList.iterator();

        while (itr.hasNext()) {
            Integer currentValue = itr.next();
            System.out.println(currentValue);
        }

    }

    public static void comparatorCodeExample() {

        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 25));
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 30));

        // Sort using comparator
        Collections.sort(students, new AgeComparator());

        System.out.println("Students sorted by age:");
        for (Student s : students) {
            System.out.println(s.name + " - " + s.age);
        }

    }

    // Main Method
    public static void main(String[] args) {

        iteratorCodeExample();
        comparatorCodeExample();

    }

}
