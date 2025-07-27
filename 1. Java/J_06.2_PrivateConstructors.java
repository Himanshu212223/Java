package learning;


/*
		If we make Private constructors we have to keep below points in mind :-
		1. We create object using constructors, but since the constructors are private,
			we need to create a static method which returns a newly created Object.
		
		2. We cannot extend the class because all the constructors are private and
			child class always requires access to parent class using super() method.
 */

class Library{
	public int totalBooks ;
	private String libraryName ;
	
	//	default constructor
	private Library() {
		
	}	
	
	//	parameterized constructor
	private Library(int totalBooks, String libraryName) {
		this.totalBooks = totalBooks ;
		this.libraryName = libraryName ;
	}
	
	public static Library createObject() {
		return new Library() ;
	}
	
}



public class J_063_PrivateConstructors {
	
	
	public static void main(String args[]) {
		
	
	//	Create object of Library
	Library lib = Library.createObject() ;
	lib.totalBooks = 5;
	
	System.out.println(lib.totalBooks);
	
		
	}
}
