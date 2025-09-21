
/*	
	CONSTRUCTORS 
	________________________
	
	- Different types of constructors are :
			1. Default or non-parameterized constructor 
			2. Copy Constructor
			3. Parameterized Constructor
			
	- Default constructor is by default provided by the compiler that's why we are able to 
		create the object of class as ClassName object = new ClassName() ;
		
	- If we make a parameterized constructor, then, compiler wouldn't provide default constructor
		and we have to make a default constructor by ourself.
		
	- Copy constructor just creates copies the attribute value of one object to another.
		but, if object1 = object2 is done, then, object1 will be referencing to object2.
		This is kind of Aliasing (i.e., giving another name to a particular variable).
		Any changes in object2 will get reflected to object1 too.
		To avoid this problem, we create Copy Constructor.
			
	- We can define a method having same name as that of class name.
	
	- Constructor can be public, private or protected.
		See next file for more details on how to use private constructor and create new object.
	
	- We use new keyword to create object and = sign is used to create reference.
*/

class Employee{
	public int id ;
	public String name ;
	
	// default constructor
	Employee(){
		
	}
	
	//	parameterized constructor
	Employee(int id, String name){
		this.id = id ;
		this.name = name ;
	}
	
	
	//	Copy Constructor
	Employee(Employee obj){
		this.id = obj.id ;
		this.name = obj.name ;
	}
	
	
	public void Employee(Employee emp) {
		System.out.println("We are fine here");
	}
}


public class J_09_0_DifferentTypesOfConstructors {
	
	
	public static void main(String args[]) {
		
	
		Employee emp1 = new Employee();
		Employee emp2 = new Employee(2, "sharma");

		emp1 = new Employee(1, "Shukla");
		
		emp2 = emp1 ;		//	 this will share same memory.
		
		Employee emp3 = new Employee(emp1);
		
		emp1.id = 4 ;
		
		System.out.println(emp1.id);
		System.out.println(emp2.id);
		System.out.println(emp3.id);
		
		emp1.Employee(emp3);
		
		
	}
}
