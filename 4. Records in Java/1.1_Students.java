/*
 	Records -
 	--------------
		- In Java, a record is a special type of class introduced in Java 14 (preview) 
			and made stable in Java 16. 
	- It is used to create immutable data classes with minimal boilerplate.
	- Records are usually used as DTO (Data Transfer Object).
*/

package learn.testing;

public record Students(int rollNo, String name) {

}


/*
	The Above Record Code is equivalent to below Class - 
	------------------------------------------------------
	
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

 */