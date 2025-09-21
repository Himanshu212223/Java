

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student{
	public int id ;
	public String name ;
	public int age ;

	public Student(int id, String name, int age) {
		this.id = id ;
		this.name = name ;
		this.age = age ;
	}
	public String toString() {
		return "  " + this.id + " " + this.name + " " + this.age + "  ";
	}
};


public class J_28_3_FlatMapInClass {
public static void main(String [] args) {
	
	List <Student> studentList1 = new ArrayList<Student>();
	studentList1.add(	new Student(1, "A", 12)		);
	studentList1.add(	new Student(2, "B", 13)		);
	studentList1.add(	new Student(3, "C", 14)		);
	
	List <Student> studentList2 = new ArrayList<Student>() ;
	studentList2.add(	new Student(4, "D", 15)		);
	studentList2.add(	new Student(5, "E", 16)		);
	studentList2.add(	new Student(6, "F", 17)		);
	
		//	lets make a complex list.
	List < List<Student> > finalList = Arrays.asList(studentList1, studentList2) ;
	
		//	now, lets perform flat map on the complex collection.
	
	List<Student> finalStudentList = finalList.stream().flatMap(obj -> obj.stream()).collect(Collectors.toList()) ;
	finalStudentList.forEach(e -> System.out.println(e));
	
	List<Student> studentListAgeAbove14 = finalList.stream().flatMap(obj -> obj.stream().filter(e -> e.age > 14)).collect(Collectors.toList()) ;
	studentListAgeAbove14.forEach(e -> System.out.println(e));
	}
}
