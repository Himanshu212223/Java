
/*
	Method Overriding :-
	____________________________
	
	- When child class want to use the same method of Parent, but the things defined inside the
		method is according to the child, then, Method Overriding is needed.
		
	- @Override annotation is generally used above the Override method of child.
	 Annotations provide supplement information about the program. 
	 It starts with '@' and does not change the flow of the program.

	- This polymorphism is called Dynamic or Run time polymorphism.
	
	- We can override the main method as well.
*/


class Animal{
	public void details() {
		System.out.println("Most of the animals are Herbivores.") ;
	}
	
	
	public static void main(String args[]) {
		System.out.println("I am overridden main.");
	}
}


class Lion extends Animal{
	@Override
	public void details() {
		System.out.println("Lion is Carnivores Animal.") ;
	}
}



class Deer extends Animal{
	@Override
	public void details() {
		System.out.println("Deer is Herbivores Animal.") ;
	}
}


public class J_14_0_MethodOverriding extends Animal {
	
	public static void main(String args[]) {
		
		Animal animal = new Animal() ;
		animal.details() ;
		
		Lion lion = new Lion() ;
		lion.details() ; 
		
		Deer deer = new Deer() ;
		deer.details() ;
	
		
	}
}