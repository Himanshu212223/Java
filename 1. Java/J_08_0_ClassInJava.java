
/*	
	A class is the blueprint or design which describes the characteristic 
		and behavior of a real-word entity.
	The below Class Student is the design which contain characteristics or attributes 
	like name, rollNo and behavior or methods like getDetailsOfStudent.
	
	- We cannot make more than 1 class as public in Java.
	- We can make static class inside main class.
	- One package cannot have multiple class with same name.
	- Main class can be only public or default.
	
*/


class Student {
	
	public int rollNo ;
	public String name ;
	
	public void setDetailsOfStudent(int r, String n) {
		rollNo = r ;
		name = n ;
	}
	
	public void getDetailsOfStudent() {
		System.out.println("Roll No .: " + rollNo) ;
		System.out.println("Name    .: " + name) ;
	}
}



public class J_08_0_ClassInJava {
	
	static class AC {
		public void printer() {
			System.out.println("Ac");
		}
	}
	
	
	public static void main(String args[]) {
		
		Student student = new Student() ;		//	making the object of the above class.
		
		int rolls = 45 ;					
		String names = "Himanshu" ;
		
		student.setDetailsOfStudent(rolls, names);		
		
		student.getDetailsOfStudent();			//	calling the method of class through object.
		
		
		//	creating object of static class defined in another class (main class).
		AC ac = new AC() ;
		ac.printer();
		
		
	}
}
