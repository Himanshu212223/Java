package learning;


/*
	Inheritance :-
	______________________________
	
	- When one class wants to get the properties of some another class, i.e., when child class
		want to get the properties of Parent class, then, Inheritance is used.
	
	- extends is used to perform Inheritance.

	- Java follows Single level, Multi-level, and Hierarchical Inheritance 
		(multiple classes can extends on class).
	
	- Java does not support Multiple Inheritance (a child class cannot extend 2 or more parent class).
*/


class Father{
	public int numberOfHouse = 3 ;
	public int numberOfCars = 5 ;
	public double bankBalance = 24537983.30 ;
	
	public static int fat = 8;
	
	Father(){
		System.out.println("I am father." + fat);
	}
	
	public void getDetails() {
		System.out.println("Total number of propeties : " + this.numberOfHouse) ;
		System.out.println("Total number of Cars 	  :	" + this.numberOfCars) ;
		System.out.println("Total Bank Balance 		  :	" + this.bankBalance) ;
		System.out.println("I am Father getDetails");
	}
};

//	Below, child class inherits Father class using extends

class Child extends Father{
	
	Child(){
		//		super();    - this is always hidden.
		fat = 7 ;
		System.out.println("I am Child." + fat);
	}
	
	public String schoolOrCollegeName = "Indian Public School" ;
	
	public void getSchoolDetails() {
		System.out.println("My School is : " + this.schoolOrCollegeName) ;
	}
	
	@Override
	public void getDetails() {
		super.getDetails();
		System.out.println("I am child getDetails.");
	}

};


public class J_09_Inheritance {
	
	public static void main(String args[]) {
		
		Father bat = new Child() ;
		bat.getDetails();
	
		
	}
}
