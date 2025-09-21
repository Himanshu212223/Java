/*
Comparable - 
___________________________________________________________

- A class itself implements Comparable if it wants to define how 
its objects should be compared.

- We can implement the Comparable Interface and can override the compareTo method
 to define how we can compare the current object with other.


*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Natural ordering by age
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }
}





public class J_24_0_Comparable {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 25));
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 30));

        Collections.sort(students); // uses compareTo

        for (Student s : students) {
            System.out.println(s.name + " - " + s.age);
        }
    }

}
